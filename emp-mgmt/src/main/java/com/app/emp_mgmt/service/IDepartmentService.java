package com.app.emp_mgmt.service;

import java.util.List;

import com.app.emp_mgmt.entity.Department;
import com.app.emp_mgmt.model.DepartmentDTO;

public interface IDepartmentService {

    DepartmentDTO createDepartment(DepartmentDTO departmentDTO);

    DepartmentDTO getDepartmentById(Long id);

    List<DepartmentDTO> getAllDepartments();

    DepartmentDTO updateDepartment(Long id, DepartmentDTO departmentDTO);

    boolean deleteDepartment(Long id);
}
