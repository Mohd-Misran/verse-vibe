package edu.isr.versevibe.controllers;

import edu.isr.versevibe.service.index.SongSearchService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SongSearchController {
    @Resource(name="searchService")
    private SongSearchService songSearchService;
}
