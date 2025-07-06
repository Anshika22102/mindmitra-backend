package com.mindmitra.backend.repository;

import com.mindmitra.backend.model.MoodEntry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MoodRepository extends JpaRepository<MoodEntry, Long> {
}
