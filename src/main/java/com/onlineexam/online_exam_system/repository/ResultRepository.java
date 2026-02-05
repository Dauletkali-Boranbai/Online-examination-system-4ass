package com.onlineexam.online_exam_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.onlineexam.online_exam_system.entity.Result;

public interface ResultRepository
        extends JpaRepository<Result, Long> {
}
