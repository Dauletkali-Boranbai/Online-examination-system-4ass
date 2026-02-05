package com.onlineexam.online_exam_system.entity;

import java.util.*;

class SingleChoiceQuestion extends Question {
    private String correctAnswer;


    public SingleChoiceQuestion(String text, String correctAnswer, int points) {
        super(text, points);
        this.correctAnswer = correctAnswer;
    }


    @Override
    public boolean checkAnswer(List<String> answers) {
        return answers.size() == 1 && answers.get(0).equalsIgnoreCase(correctAnswer);
    }
}
