package edu.isr.versevibe.controllers;

import edu.isr.versevibe.dto.Song;
import edu.isr.versevibe.service.index.SongSearchService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/search")
public class SongSearchController {
    @Resource(name = "searchService")
    private SongSearchService songSearchService;

    @PostMapping("/lyrics")
    public List<Song> getSongInformation(@RequestParam final String searchQuery) {
        return null;
    }
}
