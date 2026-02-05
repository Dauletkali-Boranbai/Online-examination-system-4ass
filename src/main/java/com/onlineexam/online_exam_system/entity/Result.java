package com.onlineexam.online_exam_system.entity;

import jakarta.persistence.*;

@Entity
public class Result {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int score;

    @ManyToOne
    @JoinColumn(name = "candidate_id")
    private Candidate candidate;

    public Result() {}

    public Result(int score, Candidate candidate) {
        this.score = score;
        this.candidate = candidate;
    }

    public Long getId() { return id; }

    public int getScore() { return score; }

    public void setScore(int score) { this.score = score; }

    public Candidate getCandidate() { return candidate; }

    public void setCandidate(Candidate candidate) {
        this.candidate = candidate;
    }
}
