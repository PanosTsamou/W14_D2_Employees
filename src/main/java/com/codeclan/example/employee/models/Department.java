package com.codeclan.example.employee.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Departments")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "Department_Name")
    private String departmentName;

    @JsonIgnoreProperties({"department","assignments"})
    @Column(name = "employees")
    @OneToMany(mappedBy = "department")
    private List<Employee> employees;

    public Department(String departmentName) {
        this.departmentName = departmentName;
        this.employees = new ArrayList<>();
    }

    public Department(){};

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void addEmployeesToDepartment(Employee employee){
        employees.add(employee);

    }


    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
