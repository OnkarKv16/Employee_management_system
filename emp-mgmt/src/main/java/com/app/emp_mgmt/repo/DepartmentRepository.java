package com.app.emp_mgmt.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.emp_mgmt.entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
	
	
}
