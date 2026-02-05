package com.onlineexam.online_exam_system.controller;

import com.onlineexam.online_exam_system.dto.ExamRequest;
import com.onlineexam.online_exam_system.entity.Candidate;
import com.onlineexam.online_exam_system.entity.Result;
import com.onlineexam.online_exam_system.repository.CandidateRepository;
import com.onlineexam.online_exam_system.repository.ResultRepository;
import com.onlineexam.online_exam_system.service.ExamService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/results")
public class ResultController {

    private final ResultRepository resultRepository;
    private final CandidateRepository candidateRepository;
    private final ExamService examService;

    public ResultController(ResultRepository resultRepository,
                            CandidateRepository candidateRepository,
                            ExamService examService) {
        this.resultRepository = resultRepository;
        this.candidateRepository = candidateRepository;
        this.examService = examService;
    }


    @PostMapping("/exam")
    public Result submitExam(@RequestBody ExamRequest request) {

        Candidate candidate = candidateRepository
                .findById(request.getCandidateId())
                .orElseThrow(() -> new RuntimeException("Candidate not found"));

        int score = examService.calculateScore(request.getAnswers());

        Result result = new Result(score, candidate);

        return resultRepository.save(result);
    }


    @GetMapping
    public List<Result> getAllResults() {
        return resultRepository.findAll();
    }
}
