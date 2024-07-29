package com.app.emp_mgmt.service;

import java.util.List;

import com.app.emp_mgmt.model.EmployeeDTO;

public interface IEmployeeService {

	EmployeeDTO createEmployee(EmployeeDTO employeeDTO);

    EmployeeDTO getEmployeeById(Long id);

    List<EmployeeDTO> getAllEmployees();

    EmployeeDTO updateEmployee(Long id, EmployeeDTO employeeDTO);

    boolean deleteEmployee(Long id);

}
