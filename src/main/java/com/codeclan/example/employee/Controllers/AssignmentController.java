package com.codeclan.example.employee.Controllers;

import com.codeclan.example.employee.models.Assignment;
import com.codeclan.example.employee.repositories.AssignmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class AssignmentController {
    @Autowired
    AssignmentRepo assignmentRepo;

    @GetMapping(value = "/assignments")
    public List<Assignment> getAssignments() {
        return assignmentRepo.findAll();
    }

    @GetMapping(value = "/assignments/{id}")
    public Optional<Assignment> getAssignment(@PathVariable Long id) {
        return assignmentRepo.findById(id);
    }

    @GetMapping(value = "/assignments/delete")
    public void deleteAll() {
        assignmentRepo.deleteAll();
    }

    @GetMapping(value = "/assignments/delete/{id}")
    public void deleteAssignment(@PathVariable Long id) {
        assignmentRepo.deleteById(id);
    }
}

