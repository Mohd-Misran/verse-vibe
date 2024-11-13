package edu.isr.versevibe.controllers;

import edu.isr.versevibe.service.index.IndexManagementService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {
    @Resource(name = "indexManagementService")
    private IndexManagementService indexManagementService;

    @GetMapping("/index")
    public boolean createIndex() {
        indexManagementService.indexDocuments();
        return true;
    }
}
