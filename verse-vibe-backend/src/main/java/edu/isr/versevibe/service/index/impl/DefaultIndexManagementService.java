package edu.isr.versevibe.service.index.impl;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch.core.BulkRequest;
import co.elastic.clients.elasticsearch.core.BulkResponse;
import co.elastic.clients.elasticsearch.core.IndexResponse;
import co.elastic.clients.elasticsearch.core.bulk.BulkOperation;
import co.elastic.clients.elasticsearch.indices.CreateIndexResponse;
import co.elastic.clients.elasticsearch.indices.DeleteIndexResponse;
import co.elastic.clients.elasticsearch.indices.ExistsRequest;
import edu.isr.versevibe.service.index.IndexManagementService;
import lombok.Getter;
import lombok.SneakyThrows;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

@Getter
public class DefaultIndexManagementService implements IndexManagementService {
    private final ElasticsearchClient searchClient;
    private static final int BATCH_SIZE = 1000;

    public DefaultIndexManagementService(final ElasticsearchClient searchClient) {
        this.searchClient = searchClient;
    }

    @SneakyThrows
    @Override
    public boolean createIndex(final String indexName, final String attributeMappings) {
        try {
            final boolean exists =
                    getSearchClient().indices().exists(ExistsRequest.of(index -> index.index(indexName))).value();
            if (Boolean.FALSE.equals(exists)) {
                final CreateIndexResponse response = getSearchClient().indices()
                        .create(index -> index.index(indexName).withJson(new StringReader(attributeMappings)));
                return response.acknowledged();
            } else {
                return true;
            }
        } catch (Exception e) {
            System.err.println("Error while creating index: " + e.getMessage());
            return false;
        }
    }

    public <SongDocument> void indexDocument(String indexName, String id, SongDocument document) throws IOException {
        IndexResponse response = getSearchClient().index(i -> i
                .index(indexName)
                .id(id)
                .document(document)
        );
        System.out.println("Indexed document " + response.id());
    }

    @SneakyThrows
    public <SongDocument> void bulkIndex(final String indexName, final List<SongDocument> documents) {
        List<BulkOperation> operations = new ArrayList<>();
        for (int i = 0; i < documents.size(); i++) {
            final String id = String.valueOf(i);
            final SongDocument document = documents.get(i);
            // Create bulk operation for each document
            final BulkOperation operation =
                    BulkOperation.of(op -> op.index(idx -> idx.index(indexName).id(id).document(document)));
            operations.add(operation);
            // Process in batches
            if (operations.size() >= BATCH_SIZE) {
                executeBulkRequest(operations);
                operations.clear();
                System.out.println("Indexed " + (i + 1) + " documents");
            }
        }
        // Index any remaining documents
        if (!operations.isEmpty()) {
            executeBulkRequest(operations);
        }
    }

    @SneakyThrows
    private void executeBulkRequest(List<BulkOperation> operations) {
        BulkRequest bulkRequest = BulkRequest.of(req -> req.operations(operations));
        BulkResponse response = getSearchClient().bulk(bulkRequest);
        // Check for errors
        if (response.errors()) {
            System.out.println("Bulk indexing had errors");
            response.items().forEach(item -> {
                if (item.error() != null) {
                    System.out.println("Error indexing document " + item.id() + ": " + item.error().reason());
                }
            });
        }
    }

    @Override
    public boolean deleteIndexIfExists(String indexName) throws IOException {
        final boolean exists = searchClient.indices().exists(e -> e.index(indexName)).value();
        if (exists) {
            return deleteIndex(indexName);
        }
        return false;
    }

    private boolean deleteIndex(String indexName) throws IOException {
        final DeleteIndexResponse response = searchClient.indices().delete(d -> d.index(indexName));
        return response.acknowledged();
    }

}
