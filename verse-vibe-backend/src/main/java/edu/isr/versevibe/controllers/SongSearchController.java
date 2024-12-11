package edu.isr.versevibe.controllers;

import edu.isr.versevibe.dto.Song;
import edu.isr.versevibe.service.index.SongSearchService;
import jakarta.annotation.Resource;
import lombok.SneakyThrows;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
public class SongSearchController {
    @Resource(name = "songSearchService")
    private SongSearchService songSearchService;

    @SneakyThrows
    @PostMapping("/search")
    public List<Song> getSongInformation(@RequestParam final String searchQuery) {
        System.out.println("Working Directory = " + System.getProperty("user.dir"));
        return songSearchService.searchAcrossFields(searchQuery);
    }
}
