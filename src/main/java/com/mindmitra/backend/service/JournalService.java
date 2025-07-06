package com.mindmitra.backend.service;

import com.mindmitra.backend.model.JournalEntry;
import com.mindmitra.backend.repository.JournalRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class JournalService {

    private final JournalRepository journalRepository;

    public JournalService(JournalRepository journalRepository) {
        this.journalRepository = journalRepository;
    }

    public JournalEntry saveEntry(String message, String userId) {
        JournalEntry entry = new JournalEntry(null, message, LocalDateTime.now(), userId);
        return journalRepository.save(entry);
    }

    public List<JournalEntry> getAllEntries() {
        return journalRepository.findAll();
    }
}
