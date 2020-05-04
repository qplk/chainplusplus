package com.chainplusplus.chainplusplus.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "answers")
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String answer;

    private int weight;

    @ManyToOne
    @JoinColumn(name = "name", nullable = false)
    private Symptom symptom;

    @ManyToMany
    @JoinTable(name = "answer_activities",
            joinColumns = {@JoinColumn(name = "answer_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "activity_id", referencedColumnName = "id")})
    private List<Activity> activities;
}
