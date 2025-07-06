package com.mindmitra.backend.controller;

import com.mindmitra.backend.model.MoodEntry;
import com.mindmitra.backend.service.MoodService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/mood")
public class MoodController {

    private final MoodService moodService;

    public MoodController(MoodService moodService) {
        this.moodService = moodService;
    }

    @PostMapping
    public MoodEntry logMood(@RequestBody MoodEntry entry) {
        return moodService.logMood(entry.getMood(), entry.getUserId());
    }

    @GetMapping
    public List<MoodEntry> getAllMoods() {
        return moodService.getAllMoods();
    }
}
