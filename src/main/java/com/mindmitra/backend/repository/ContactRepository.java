package com.mindmitra.backend.repository;

import com.mindmitra.backend.model.EmergencyContact;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContactRepository extends JpaRepository<EmergencyContact, Long> {
    List<EmergencyContact> findByUserId(String userId);
}
