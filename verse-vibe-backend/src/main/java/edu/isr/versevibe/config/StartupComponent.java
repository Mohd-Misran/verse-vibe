package edu.isr.versevibe.config;

import com.fasterxml.jackson.databind.MappingIterator;
import edu.isr.versevibe.dto.SongDocument;
import edu.isr.versevibe.service.index.IndexManagementService;
import edu.isr.versevibe.utils.CSVUtils;
import edu.isr.versevibe.utils.IOUtils;
import jakarta.annotation.Resource;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static edu.isr.versevibe.constants.Constants.ATTRIBUTE_MAPPINGS;
import static edu.isr.versevibe.constants.Constants.INDEX_NAME;


public class StartupComponent {

    @Value("${lyrics.file.path}")
    private String filePath;

    @Value("${document.batch.size}")
    private int batchSize;

    @Resource(name = "indexManagementService")
    private IndexManagementService indexManagementService;

    @SneakyThrows
    public void indexDocuments() {
        int documentCounter = 0;
        List<SongDocument> songDocumentList = new ArrayList<>(batchSize);
        indexManagementService.deleteIndexIfExists(INDEX_NAME);
        System.out.println("------------------------------------------------------------------------");
        System.out.println("Indexing song documents");
        final boolean indexCreated = indexManagementService.createIndex(INDEX_NAME, ATTRIBUTE_MAPPINGS);
        try (MappingIterator<Map<String, String>> csvIterator = IOUtils.initReader(filePath)) {
            if (Boolean.TRUE.equals(indexCreated)) {
                while (csvIterator.hasNext()) {
                    if (documentCounter >= batchSize) {
                        indexManagementService.bulkIndex(INDEX_NAME, songDocumentList);
                        documentCounter = 0;
                        songDocumentList = new ArrayList<>();
                    }
                    final Map<String, String> csvRecord = csvIterator.next();
                    final SongDocument songDocument = CSVUtils.populateSongDTO(csvRecord);
                    songDocumentList.add(songDocument);
                    documentCounter++;
                }
            } else {
                System.out.println("Error while creating index");
            }
        }
    }

}
