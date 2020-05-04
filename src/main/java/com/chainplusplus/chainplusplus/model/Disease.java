package com.chainplusplus.chainplusplus.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "diseases")
public class Disease {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String name;

    @ManyToMany
    @JoinTable(name = "disease_symptoms",
            joinColumns = {@JoinColumn(name = "disease_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "symptom_id", referencedColumnName = "id")})
    private List<Symptom> symptoms;


}
