package edu.isr.versevibe.service.index.impl;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch.core.SearchResponse;
import co.elastic.clients.elasticsearch.core.search.Hit;
import edu.isr.versevibe.dto.Song;
import edu.isr.versevibe.dto.SongDocument;
import edu.isr.versevibe.service.index.SongSearchService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static edu.isr.versevibe.constants.Constants.INDEX_NAME;

@Service("songSearchService")
public class DefaultSongSearchService implements SongSearchService {
    private final ElasticsearchClient elasticsearchClient;

    public DefaultSongSearchService(final ElasticsearchClient elasticsearchClient) {
        this.elasticsearchClient = elasticsearchClient;
    }


    @Override
    public List<Song> searchAcrossFields(String searchTerm) throws IOException {
        final SearchResponse<SongDocument> searchResponse = elasticsearchClient.search(s -> s.index(INDEX_NAME)
                        .query(q -> q.multiMatch(m -> m.fields("title", "lyrics^1.5", "artist").query(searchTerm))),
                SongDocument.class);
        return extractHits(searchResponse);
    }

    private List<Song> extractHits(SearchResponse<SongDocument> response) {
        List<Song> songs = new ArrayList<>();
        for (Hit<SongDocument> hit : response.hits().hits()) {
            final SongDocument songDocument = hit.source();
            final Song song = new Song();
            song.setTitle(songDocument.getTitle());
            song.setArtist(songDocument.getArtist());
            song.setYear(songDocument.getYear());
            songs.add(song);
        }
        return songs;
    }
}
