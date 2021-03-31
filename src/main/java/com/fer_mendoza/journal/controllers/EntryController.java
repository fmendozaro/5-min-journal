package com.fer_mendoza.journal.controllers;

import com.fer_mendoza.journal.models.Entry;
import com.fer_mendoza.journal.repositories.EntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EntryController {

    @Autowired
    private EntryRepository entryRepository;

    @GetMapping("/entries")
    public List<Entry> index() {
        return entryRepository.findAll();
    }

    @GetMapping("/entries/{id}")
    public Entry show(@PathVariable long id) {
        return entryRepository.getOne(id);
    }

}