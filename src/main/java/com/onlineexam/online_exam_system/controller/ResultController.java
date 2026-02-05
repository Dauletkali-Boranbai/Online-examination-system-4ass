package com.onlineexam.online_exam_system.controller;

import com.onlineexam.online_exam_system.entity.Result;
import com.onlineexam.online_exam_system.repository.ResultRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.onlineexam.online_exam_system.entity.Candidate;
import com.onlineexam.online_exam_system.repository.CandidateRepository;

@RestController
@RequestMapping("/results")
public class ResultController {

    private final ResultRepository resultRepo;
    private final CandidateRepository candidateRepo;

    public ResultController(ResultRepository resultRepo,
                            CandidateRepository candidateRepo) {
        this.resultRepo = resultRepo;
        this.candidateRepo = candidateRepo;
    }

    @PostMapping("/{candidateId}")
    public Result addResult(@PathVariable Long candidateId,
                            @RequestBody Result result){

        Candidate candidate =
                candidateRepo.findById(candidateId).orElseThrow();

        result.setCandidate(candidate);

        return resultRepo.save(result);
    }

    @GetMapping
    public List<Result> getAll(){
        return resultRepo.findAll();
    }
}
