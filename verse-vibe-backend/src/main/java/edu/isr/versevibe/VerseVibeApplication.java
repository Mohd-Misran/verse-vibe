package edu.isr.versevibe;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import edu.isr.versevibe.config.ElasticSearchConfig;
import edu.isr.versevibe.dto.SongDocument;
import edu.isr.versevibe.service.indexing.IndexingService;
import edu.isr.versevibe.service.indexing.impl.DefaultIndexingService;
import edu.isr.versevibe.utils.CSVUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

import static edu.isr.versevibe.constants.Constants.ATTRIBUTE_MAPPINGS;
import static edu.isr.versevibe.constants.Constants.INDEX_NAME;

@SpringBootApplication
public class VerseVibeApplication {

    public static void main(String[] args) {
        final List<SongDocument> songDocumentList = CSVUtils.readCSV("src/main/resources/documents/song_lyrics.csv");
        final ElasticsearchClient searchClient = ElasticSearchConfig.createClient();
        final IndexingService indexingService = new DefaultIndexingService(searchClient);
        indexingService.createIndex(INDEX_NAME, ATTRIBUTE_MAPPINGS);
        indexingService.bulkIndex(INDEX_NAME, songDocumentList);
        SpringApplication.run(VerseVibeApplication.class, args);
    }

}
