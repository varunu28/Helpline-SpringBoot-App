package com.example.demo.api;

import com.example.demo.model.Entry;
import com.example.demo.service.EntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;


@RequestMapping("/api/v1/entry")
@RestController
public class EntryController {

    private final EntryService entryService;

    @Autowired
    public EntryController(EntryService entryService) {
        this.entryService = entryService;
    }

    @PostMapping
    public void addEntry(@RequestBody Entry entry) throws IOException {
        entryService.addPerson(entry);
    }
}

