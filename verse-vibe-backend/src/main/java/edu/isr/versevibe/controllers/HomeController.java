package edu.isr.versevibe.controllers;

import edu.isr.versevibe.service.index.SongSearchService;
import edu.isr.versevibe.service.spotify.SpotifyService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @Resource
    private SongSearchService searchService;

    @Resource(name = "spotifyService")
    private SpotifyService spotifyService;

    @GetMapping("/")
    public String home() {
        spotifyService.searchTrack(null, null);
        return "Hello World";
    }
}
