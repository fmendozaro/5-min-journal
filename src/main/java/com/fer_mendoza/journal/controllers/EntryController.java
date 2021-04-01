package com.fer_mendoza.journal.controllers;

import com.fer_mendoza.journal.models.Entry;
import com.fer_mendoza.journal.repositories.EntryRepository;
import com.fer_mendoza.journal.services.EntrySvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/entries")
public class EntryController {

    @Autowired
    private EntrySvc entrySvc;

    @GetMapping("/")
    public List<Entry> index() {
        return entrySvc.all();
    }

    @GetMapping("/{id}")
    public Entry show(@PathVariable long id) {
        return entrySvc.get(id);
    }

    @PostMapping("/")
    public ResponseEntity<Entry> create(@RequestBody Entry entry){
        Entry createdEntry = entrySvc.createOrUpdate(entry);
        if(createdEntry == null){
            return ResponseEntity.notFound().build();
        }
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(createdEntry.getId())
                .toUri();
        return ResponseEntity.created(uri).body(createdEntry);
    }

    @PutMapping("/")
    public ResponseEntity<Entry> update(@RequestBody Entry entry){
        Entry createdEntry = entrySvc.createOrUpdate(entry);
        if(createdEntry == null){
            return ResponseEntity.notFound().build();
        }
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(createdEntry.getId())
                .toUri();
        return ResponseEntity.created(uri).body(createdEntry);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteStudent(@PathVariable Long id) {
        entrySvc.delete(id);
        return ResponseEntity.noContent().build();
    }

}