package com.onlineexam.online_exam_system.repository;

import com.onlineexam.online_exam_system.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Long> {
}


