package edu.isr.versevibe.utils;

import com.opencsv.CSVReader;
import edu.isr.versevibe.dto.SongDocument;
import lombok.SneakyThrows;
import org.apache.commons.lang3.StringUtils;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import static org.apache.commons.lang3.StringUtils.EMPTY;

public class CSVUtils {
    @SneakyThrows
    public static List<SongDocument> readCSV(final String filePath) {
        //TODO Implement Batch Size processing
        final List<SongDocument> songDocumentList = new ArrayList<>();
        final FileReader fileReader = new FileReader(filePath);
        final CSVReader csvReader = new CSVReader(fileReader);
        final String[] ignoredHeader = csvReader.readNext();
        String[] nextRecord;
        while (Objects.nonNull(nextRecord = csvReader.readNext())) {
            final SongDocument songDocument = populateSongDTO(nextRecord);
            songDocumentList.add(songDocument);
        }
        return songDocumentList;
    }

    private static SongDocument populateSongDTO(final String[] nextRecord) {
        final SongDocument songDocument = new SongDocument();
        songDocument.setTitle(nextRecord[0]);
        songDocument.setTag(nextRecord[1]);
        songDocument.setArtist(new ArrayList<>(populateArtistData(nextRecord[2], nextRecord[5])));
        songDocument.setYear(nextRecord[3]);
        songDocument.setFeatures(nextRecord[5]);
        songDocument.setLyrics(nextRecord[6]);
        songDocument.setId(nextRecord[7]);
        songDocument.setLanguage(nextRecord[10]);
        songDocument.setGeneratedAt(new Date());
        return songDocument;
    }

    @SneakyThrows
    private static Set<String> populateArtistData(final String artistName, final String features) {
        final String cleanedFeaturesValue = cleanFeaturesValue(features);
        final Set<String> currentArtistList = new HashSet<>();
        currentArtistList.add(artistName);
        if (StringUtils.isNotEmpty(cleanedFeaturesValue)) {
            currentArtistList.addAll(List.of(cleanedFeaturesValue.split(",")));
        }
        return currentArtistList;
    }

    private static String cleanFeaturesValue(final String features) {
        String cleanedFeaturesValue = null;
        if (StringUtils.isNotEmpty(features)) {
            cleanedFeaturesValue =
                    features.replace("\"", EMPTY).replace("{", EMPTY).replace("}", EMPTY).replace("\\", EMPTY);
        }
        return cleanedFeaturesValue;
    }
}
