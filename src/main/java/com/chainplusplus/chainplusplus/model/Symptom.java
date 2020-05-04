package com.chainplusplus.chainplusplus.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "symptoms")
public class Symptom {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String name;

    @ManyToMany(mappedBy = "symptoms")
    private List<Disease> diseases;

    @OneToMany(mappedBy = "symptom")
    private List<Answer> answers;

    @ManyToMany
    @JoinTable(name = "symptom_activities",
            joinColumns = {@JoinColumn(name = "symptom_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "activity_id", referencedColumnName = "id")})
    private List<Activity> activities;
}
