package com.onlineexam.online_exam_system.service;

import com.onlineexam.online_exam_system.entity.Question;
import com.onlineexam.online_exam_system.repository.QuestionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ExamService {

    private final QuestionRepository questionRepository;

    public ExamService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public int calculateScore(Map<String, List<String>> answers) {
        int score = 0;

        List<Question> questions = questionRepository.findAll();

        for (Question q : questions) {
            List<String> userAnswers = answers.get(q.getId().toString());

            if (userAnswers != null && q.checkAnswer(userAnswers)) {
                score += q.getPoints();
            }
        }

        return score;
    }
}

