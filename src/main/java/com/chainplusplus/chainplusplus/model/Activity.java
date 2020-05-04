package com.chainplusplus.chainplusplus.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "activities")
@Data
public class Activity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String activity;

    private int frequency;
    private String dimension;

    @ManyToMany(mappedBy = "activities")
    private List<User> users;

    @ManyToMany(mappedBy = "activities")
    private List<Answer> answers;

    @ManyToMany(mappedBy = "activities")
    private List<Symptom> symptoms;
}
