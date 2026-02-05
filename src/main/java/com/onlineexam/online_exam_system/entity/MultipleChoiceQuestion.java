package com.onlineexam.online_exam_system.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@DiscriminatorValue("MULTIPLE")
public class MultipleChoiceQuestion extends Question {

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(
            name = "multiple_question_answers",
            joinColumns = @JoinColumn(name = "question_id")
    )
    @Column(name = "answer")
    private List<String> correctAnswers;

    public MultipleChoiceQuestion() {}

    public MultipleChoiceQuestion(String text, List<String> correctAnswers, int points) {
        super(text, points);
        this.correctAnswers = correctAnswers;
    }

    public List<String> getCorrectAnswers() {
        return correctAnswers;
    }

    public void setCorrectAnswers(List<String> correctAnswers) {
        this.correctAnswers = correctAnswers;
    }

    @Override
    public boolean checkAnswer(List<String> answers) {
        if (answers == null || correctAnswers == null) return false;

        return answers.containsAll(correctAnswers)
                && correctAnswers.containsAll(answers);
    }
}
