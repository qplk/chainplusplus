package com.chainplusplus.chainplusplus.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Enumerated
    @Column(name = "role")
    private Role role;

    @ManyToMany
    @JoinTable(name = "user_activities",
            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "activity_id", referencedColumnName = "id")})
    private List<Activity> activities;

    //jsonb in db
    private String schedule;

}
