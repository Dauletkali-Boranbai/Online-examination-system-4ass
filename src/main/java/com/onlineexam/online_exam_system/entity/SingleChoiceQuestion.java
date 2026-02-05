package com.onlineexam.online_exam_system.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

import java.util.*;

@Entity
@DiscriminatorValue("SINGLE")
public class SingleChoiceQuestion extends Question {

    private String correctAnswer;

    public SingleChoiceQuestion() {}

    public SingleChoiceQuestion(String text, String correctAnswer, int points) {
        super(text, points);
        this.correctAnswer = correctAnswer;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    @Override
    public boolean checkAnswer(List<String> answers) {
        if (answers == null || answers.isEmpty()) return false;
        return correctAnswer.equals(answers.get(0));
    }

}
