package com.mindmitra.backend.service;

import com.mindmitra.backend.model.MoodEntry;
import com.mindmitra.backend.repository.MoodRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MoodService {

    private final MoodRepository moodRepository;

    public MoodService(MoodRepository moodRepository) {
        this.moodRepository = moodRepository;
    }

    public MoodEntry logMood(String mood, String userId) {
        MoodEntry entry = new MoodEntry(null, mood, LocalDateTime.now(), userId);
        return moodRepository.save(entry);
    }

    public List<MoodEntry> getAllMoods() {
        return moodRepository.findAll();
    }
}
