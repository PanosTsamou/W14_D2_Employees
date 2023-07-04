package com.codeclan.example.employee.Controllers;

import com.codeclan.example.employee.models.Department;
import com.codeclan.example.employee.models.Employee;
import com.codeclan.example.employee.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController {
    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping(value = "/employees")
    public List<Employee> getEmployees(){
        return employeeRepository.findAll();
    }
    @GetMapping(value = "/employees/{id}")
    public Optional<Employee> getEmployee(@PathVariable Long id){
        return employeeRepository.findById(id);
    }
    @GetMapping(value = "/employees/delete")
    public void deleteAll(){
        employeeRepository.deleteAll();
    }
    @GetMapping(value = "/employees/delete/{id}")
    public void deleteEmployee(@PathVariable Long id){
        employeeRepository.deleteById(id);
    }
//    @GetMapping(value = "/employees/add")
//    public void addEmployee(){
//
//        Employee newEmployee = new Employee("Panos", 23, 4545,"Panos23@gmail.com");
//        employeeRepository.save(newEmployee);
//    }
//    @PutMapping (value = "/employees/{id}")
//    public Employee updateEmployee(@PathVariable Long id , @RequestBody Employee emp){
//       emp.setId(id);
//      return employeeRepository.save(emp);
//
//    }
}
