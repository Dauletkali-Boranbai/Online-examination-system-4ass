package com.onlineexam.online_exam_system.entity;

import java.util.*;

class MultipleChoiceQuestion extends Question {
    private List<String> correctAnswers;


    public MultipleChoiceQuestion(String text, List<String> correctAnswers, int points) {
        super(text, points);
        this.correctAnswers = correctAnswers;
    }


    @Override
    public boolean checkAnswer(List<String> answers) {
        return answers.containsAll(correctAnswers) && correctAnswers.containsAll(answers);
    }
}
