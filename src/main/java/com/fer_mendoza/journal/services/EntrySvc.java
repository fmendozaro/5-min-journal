package com.fer_mendoza.journal.services;

import com.fer_mendoza.journal.models.Entry;
import com.fer_mendoza.journal.repositories.EntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("entryService")
public class EntrySvc {

    @Autowired
    private EntryRepository entryRepo;

    public List<Entry> all() {
        return entryRepo.findAll();
    }

    public Entry get(long id) {
        return entryRepo.getOne(id);
    }

    public Entry createOrUpdate(Entry entryToBeSaved) {
        return entryRepo.save(entryToBeSaved);
    }

    public void delete(long id) {
        entryRepo.deleteById(id);
    }

}
