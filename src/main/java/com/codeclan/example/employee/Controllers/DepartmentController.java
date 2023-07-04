package com.codeclan.example.employee.Controllers;

import com.codeclan.example.employee.models.Department;
import com.codeclan.example.employee.repositories.DepartmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class DepartmentController {
    @Autowired
    DepartmentRepo departmentRepo;

    @GetMapping(value = "/departments")
    public List<Department> getDepartments() {
        return departmentRepo.findAll();
    }

    @GetMapping(value = "/departments/{id}")
    public Optional<Department> getDepartment(@PathVariable Long id) {
        return departmentRepo.findById(id);
    }

    @GetMapping(value = "/departments/delete")
    public void deleteAll() {
        departmentRepo.deleteAll();
    }

    @GetMapping(value = "/departments/delete/{id}")
    public void deleteDepartment(@PathVariable Long id) {
        departmentRepo.deleteById(id);
    }
}
