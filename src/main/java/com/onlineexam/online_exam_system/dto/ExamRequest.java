package com.onlineexam.online_exam_system.dto;

import java.util.List;
import java.util.Map;

public class ExamRequest {

    private Long candidateId;
    private Map<String, List<String>> answers;

    public Long getCandidateId() {
        return candidateId;
    }

    public void setCandidateId(Long candidateId) {
        this.candidateId = candidateId;
    }

    public Map<String, List<String>> getAnswers() {
        return answers;
    }

    public void setAnswers(Map<String, List<String>> answers) {
        this.answers = answers;
    }
}
