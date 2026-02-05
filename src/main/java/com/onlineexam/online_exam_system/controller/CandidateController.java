package com.onlineexam.online_exam_system.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.onlineexam.online_exam_system.entity.Candidate;
import com.onlineexam.online_exam_system.repository.CandidateRepository;

@RestController
@RequestMapping("/candidates")
public class CandidateController {

    private final CandidateRepository repo;

    public CandidateController(CandidateRepository repo) {
        this.repo = repo;
    }

    @PostMapping
    public Candidate create(@RequestBody Candidate c){
        return repo.save(c);
    }

    @GetMapping
    public List<Candidate> getAll(){
        return repo.findAll();
    }

    // ⭐ ВОТ ЭТО ДОБАВЬ
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        repo.deleteById(id);
    }
}
