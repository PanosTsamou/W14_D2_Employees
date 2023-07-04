package com.codeclan.example.employee.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Projects")
public class Project {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;
    @Column(name = "duration_in_days")
    private int durationInDays;

    @JsonIgnoreProperties({"project","employee","assignment"})
    @Column(name = "assignments")
    @OneToMany(mappedBy = "project")
    private List<Assignment> assignments;

    public Project() {
    }

    public Project(String name, int durationInDays) {
        this.name = name;
        this.durationInDays = durationInDays;
        this.assignments = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDurationInDays() {
        return durationInDays;
    }

    public void setDurationInDays(int durationInDays) {
        this.durationInDays = durationInDays;
    }

    public List<Assignment> getAssignments() {
        return assignments;
    }

    public void setAssignments(List<Assignment> assignments) {
        this.assignments = assignments;
    }
}
