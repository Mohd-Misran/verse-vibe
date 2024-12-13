package edu.isr.versevibe.controllers;

import edu.isr.versevibe.dto.Song;
import edu.isr.versevibe.dto.spotify.SpotifySearchResponse;
import edu.isr.versevibe.service.index.SongSearchService;
import edu.isr.versevibe.service.spotify.SpotifyService;
import jakarta.annotation.Resource;
import lombok.SneakyThrows;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
public class SongSearchController {
    @Resource(name = "songSearchService")
    private SongSearchService songSearchService;

    @Resource(name = "spotifyService")
    private SpotifyService spotifyService;

    @SneakyThrows
    @GetMapping("/search")
    public List<Song> getSongInformation(@RequestParam final String searchQuery) {
        System.out.println("Working Directory = " + System.getProperty("user.dir"));
        List<Song> songs = songSearchService.searchAcrossFields(searchQuery);
        for (Song song: songs) {
            String artist = song.getArtists().isEmpty() ? null: song.getArtists().get(0);
            SpotifySearchResponse spotifyResponse = spotifyService.searchTrack(song.getTitle(), artist);
        }
        return songSearchService.searchAcrossFields(searchQuery);
    }
}
