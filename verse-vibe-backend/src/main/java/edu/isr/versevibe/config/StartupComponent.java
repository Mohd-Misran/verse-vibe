package edu.isr.versevibe.config;

import com.opencsv.CSVReader;
import edu.isr.versevibe.dto.SongDocument;
import edu.isr.versevibe.service.index.IndexManagementService;
import edu.isr.versevibe.utils.CSVUtils;
import edu.isr.versevibe.utils.IOUtils;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import lombok.SneakyThrows;
import org.apache.commons.lang3.tuple.Pair;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

import static edu.isr.versevibe.constants.Constants.ATTRIBUTE_MAPPINGS;
import static edu.isr.versevibe.constants.Constants.INDEX_NAME;

@Component
public class StartupComponent {

    @Value("${lyrics.file.path}")
    private String filePath;

    @Resource(name = "indexManagementService")
    private IndexManagementService indexManagementService;

    @SneakyThrows
    @PostConstruct
    public void indexDocuments() {
        boolean endOfFile = false;
        //indexManagementService.deleteIndexIfExists(INDEX_NAME);
        System.out.println("------------------------------------------------------------------------");
        System.out.println("Indexing song documents");
        //final boolean indexCreated = indexManagementService.createIndex(INDEX_NAME, ATTRIBUTE_MAPPINGS);
        final CSVReader csvReader = IOUtils.initReader(filePath);
        final String[] ignoredHeader = csvReader.readNext();
        if (Boolean.TRUE.equals(true)) {
            while (Boolean.FALSE.equals(endOfFile)) {
                final Pair<List<SongDocument>, Boolean> songDocumentListAndEndofFilepair = CSVUtils.readCSV(csvReader);
                final List<SongDocument> songDocumentList = songDocumentListAndEndofFilepair.getLeft();
                endOfFile = songDocumentListAndEndofFilepair.getRight();
                //indexManagementService.bulkIndex(INDEX_NAME, songDocumentList);
            }
        } else {
            System.out.println("Could not create index");
        }
    }

}
