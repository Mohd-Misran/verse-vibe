package edu.isr.versevibe.service.indexing;

import java.util.List;

public interface IndexingService {
    boolean createIndex(final String indexName, final String attributeMappings);

    <SongDocument> void bulkIndex(final String indexName, final List<SongDocument> documents);
}
