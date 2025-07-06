package com.mindmitra.backend.controller;

import com.mindmitra.backend.model.JournalEntry;
import com.mindmitra.backend.service.JournalService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*") // Allow frontend connection
@RestController
@RequestMapping("/api/journal")
public class JournalController {

    private final JournalService journalService;

    public JournalController(JournalService journalService) {
        this.journalService = journalService;
    }

    @PostMapping
    public JournalEntry createEntry(@RequestBody JournalEntry entry) {
        return journalService.saveEntry(entry.getMessage(), entry.getUserId());
    }

    @GetMapping
    public List<JournalEntry> getAll() {
        return journalService.getAllEntries();
    }
}
