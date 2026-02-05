package com.onlineexam.online_exam_system.controller;

import com.onlineexam.online_exam_system.entity.MultipleChoiceQuestion;
import com.onlineexam.online_exam_system.entity.Question;
import com.onlineexam.online_exam_system.entity.SingleChoiceQuestion;
import com.onlineexam.online_exam_system.repository.QuestionRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/questions")
public class QuestionController {

    private final QuestionRepository questionRepo;

    public QuestionController(QuestionRepository questionRepo) {
        this.questionRepo = questionRepo;
    }

    @PostMapping("/single")
    public SingleChoiceQuestion createSingle(
            @RequestBody SingleChoiceQuestion question) {
        return questionRepo.save(question);
    }

    @PostMapping("/multiple")
    public MultipleChoiceQuestion createMultiple(
            @RequestBody MultipleChoiceQuestion question) {
        return questionRepo.save(question);
    }

    @GetMapping
    public List<Question> getAll() {
        return questionRepo.findAll();
    }
}
