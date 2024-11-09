package edu.isr.versevibe.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.opencsv.CSVReader;
import edu.isr.versevibe.dto.SongDocument;
import lombok.SneakyThrows;
import org.apache.commons.collections.CollectionUtils;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CSVUtils {
    @SneakyThrows
    public static void readCSV(final String filePath) {
        final List<SongDocument> songDocumentList = new ArrayList<>();
        final FileReader fileReader = new FileReader(filePath);
        final CSVReader csvReader = new CSVReader(fileReader);
        final String[] ignoredHeader = csvReader.readNext();
        String[] nextRecord;
        while (Objects.nonNull(nextRecord = csvReader.readNext())) {
            final SongDocument songDocument = populateSongDTO(nextRecord);
            songDocumentList.add(songDocument);
        }
    }

    private static SongDocument populateSongDTO(final String[] nextRecord) {
        final SongDocument songDocument = new SongDocument();
        songDocument.setTitle(nextRecord[0]);
        songDocument.setTag(nextRecord[1]);
        songDocument.setArtist(populateArtistData(songDocument, nextRecord[2]));
        songDocument.setYear(nextRecord[3]);
        songDocument.setFeatures(nextRecord[5]);
        songDocument.setLyrics(nextRecord[6]);
        songDocument.setId(nextRecord[7]);
        songDocument.setLanguage(nextRecord[10]);
        return songDocument;
    }

    @SneakyThrows
    private static List<String> populateArtistData(SongDocument songDocument, final String artistNames) {
        List<String> currentArtistList;
        final ObjectMapper objectMapper = new ObjectMapper();
        List<String> artists = objectMapper.readValue(artistNames, new TypeReference<>() {
        });
        if (CollectionUtils.isNotEmpty(songDocument.getArtist())) {
            currentArtistList = songDocument.getArtist();
            currentArtistList.addAll(artists);
        } else {
            currentArtistList = new ArrayList<>(artists);
        }
        return currentArtistList;
    }
}
