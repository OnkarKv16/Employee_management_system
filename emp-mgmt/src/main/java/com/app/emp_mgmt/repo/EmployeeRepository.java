package com.app.emp_mgmt.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.emp_mgmt.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    // Additional query methods can be defined here if needed
    // For example, you can add custom queries using Spring Data JPA query methods

    // Find employees by their role
    List<Employee> findByRole(String role);

    // Find employees by department
    List<Employee> findByDepartment(String department);
}
