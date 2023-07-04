package com.codeclan.example.employee.repositories;

import com.codeclan.example.employee.models.Assignment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssignmentRepo extends JpaRepository<Assignment,Long> {
}
