package com.codeclan.example.employee.Controllers;

import com.codeclan.example.employee.models.Project;
import com.codeclan.example.employee.repositories.ProjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class ProjectController {
    @Autowired
    ProjectRepo projectRepo;

    @GetMapping(value = "/projects")
    public List<Project> getProjects() {
        return projectRepo.findAll();
    }

    @GetMapping(value = "/projects/{id}")
    public Optional<Project> getProject(@PathVariable Long id) {
        return projectRepo.findById(id);
    }

    @GetMapping(value = "/projects/delete")
    public void deleteAll() {
        projectRepo.deleteAll();
    }

    @GetMapping(value = "/projects/delete/{id}")
    public void deleteProject(@PathVariable Long id) {
        projectRepo.deleteById(id);
    }
}
