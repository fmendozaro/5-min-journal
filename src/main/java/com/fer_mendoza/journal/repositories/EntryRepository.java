package com.fer_mendoza.journal.repositories;

import com.fer_mendoza.journal.models.Entry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntryRepository extends JpaRepository<Entry, Long> {
}