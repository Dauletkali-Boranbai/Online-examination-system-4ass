package com.onlineexam.online_exam_system.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "question_type")
public abstract class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    protected String text;
    protected int points;

    public Question() {}

    public Question(String text, int points) {
        this.text = text;
        this.points = points;
    }

    public Long getId() { return id; }
    public String getText() { return text; }
    public int getPoints() { return points; }

    public void setText(String text) { this.text = text; }
    public void setPoints(int points) { this.points = points; }

    public abstract boolean checkAnswer(List<String> answers);
}
