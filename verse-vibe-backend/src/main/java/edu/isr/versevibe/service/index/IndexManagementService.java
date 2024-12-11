package edu.isr.versevibe.service.index;

import java.io.IOException;
import java.util.List;

public interface IndexManagementService {
    boolean createIndex(final String indexName, final String attributeMappings);

    <SongDocument> void bulkIndex(final String indexName, final List<SongDocument> documents);

    boolean deleteIndexIfExists(final String indexName) throws IOException;

    void indexDocuments();
}
