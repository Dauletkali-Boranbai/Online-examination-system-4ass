package com.onlineexam.online_exam_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.onlineexam.online_exam_system.entity.Candidate;

public interface CandidateRepository
        extends JpaRepository<Candidate, Long> {
}

