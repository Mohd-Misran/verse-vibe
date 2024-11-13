package edu.isr.versevibe.controllers;

import edu.isr.versevibe.service.index.SongSearchService;
import jakarta.annotation.Resource;
import lombok.SneakyThrows;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @Resource
    private SongSearchService searchService;

    @GetMapping("/")
    public String home() {
        return "Hello World";
    }

    @SneakyThrows
    @GetMapping("/search")
    public String search(@RequestParam String lyrics) {
        searchService.searchAcrossFields(lyrics);
        return null;
    }
}
