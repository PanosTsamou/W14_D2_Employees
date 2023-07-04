package com.codeclan.example.employee;

import com.codeclan.example.employee.models.Assignment;
import com.codeclan.example.employee.models.Department;
import com.codeclan.example.employee.models.Employee;
import com.codeclan.example.employee.models.Project;
import com.codeclan.example.employee.repositories.AssignmentRepo;
import com.codeclan.example.employee.repositories.DepartmentRepo;
import com.codeclan.example.employee.repositories.EmployeeRepository;
import com.codeclan.example.employee.repositories.ProjectRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class EmployeeApplicationTests {
	@Autowired
	EmployeeRepository employeeRepository;
	@Autowired
	DepartmentRepo departmentRepo;
	@Autowired
	ProjectRepo projectRepo;
	@Autowired
	AssignmentRepo assignmentRepo;

	@Test
	void contextLoads() {
	}
	@Test
	public void createAnEmployee(){
		Department department = new Department("Human Resources");
		Project project = new Project("CodeClan", 100);
		Employee calum = new Employee("Calum", 23, 4523,"calum23@gmail.com", department);
		Employee panos = new Employee("Panos", 23, 4545,"Panos23@gmail.com", department);
		Assignment assignment1 = new Assignment(project,calum,"12/3/24");
		Assignment assignment2 = new Assignment(project, panos, "12/3/24");
		List<Assignment> assignments = new ArrayList<>();
		assignments.add(assignment1);
		assignments.add(assignment2);
		List<Employee> employees = new ArrayList<>();
		employees.add(calum);
		employees.add(panos);
		department.setEmployees(employees);
		project.setAssignments(assignments);
		calum.addAssignment(assignment1);
		panos.addAssignment(assignment2);
		departmentRepo.save(department);
		employeeRepository.save(calum);
		employeeRepository.save(panos);
		projectRepo.save(project);
		assignmentRepo.save(assignment1);
		assignmentRepo.save(assignment2);


	}

}
