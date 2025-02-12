package com.app.emp_mgmt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import com.app.emp_mgmt.entity.Employee;
import com.app.emp_mgmt.model.EmployeeDTO;
import com.app.emp_mgmt.service.IEmployeeService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private IEmployeeService employeeService;

    @PostMapping
    public ResponseEntity<EmployeeDTO> createEmployee(@RequestBody EmployeeDTO employeeDTO) {
        EmployeeDTO createdEmployee = employeeService.createEmployee(employeeDTO);
        return new ResponseEntity<>(createdEmployee, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable Long id) {
        EmployeeDTO employeeDTO = employeeService.getEmployeeById(id);
        if (employeeDTO != null) {
            return new ResponseEntity<>(employeeDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<EmployeeDTO>> getAllEmployees() {
        List<EmployeeDTO> employees = employeeService.getAllEmployees();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmployeeDTO> updateEmployee(@PathVariable Long id, @RequestBody EmployeeDTO employeeDTO) {
        EmployeeDTO updatedEmployee = employeeService.updateEmployee(id, employeeDTO);
        if (updatedEmployee != null) {
            return new ResponseEntity<>(updatedEmployee, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
        boolean isDeleted = employeeService.deleteEmployee(id);
        if (isDeleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}








//package com.app.emp_mgmt.controller;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//import org.modelmapper.ModelMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.app.emp_mgmt.entity.Employee;
//import com.app.emp_mgmt.model.EmployeeDTO;
//import com.app.emp_mgmt.service.IEmployeeService;
//
//@RestController
//@RequestMapping("/api/employees")
//public class EmployeeController {
//	
//	private final IEmployeeService employeeService;
//    private final ModelMapper modelMapper;
//
//    @Autowired
//    public EmployeeController(IEmployeeService employeeService, ModelMapper modelMapper) {
//        this.employeeService = employeeService;
//        this.modelMapper = modelMapper;
//    }
//
//    @PostMapping
//    public ResponseEntity<EmployeeDTO> createEmployee(@RequestBody EmployeeDTO employeeDTO) {
//        Employee employee = modelMapper.map(employeeDTO, Employee.class);
//        Employee savedEmployee = employeeService.saveEmployee(employee);
//        EmployeeDTO savedEmployeeDTO = modelMapper.map(savedEmployee, EmployeeDTO.class);
//        return ResponseEntity.ok(savedEmployeeDTO);
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<EmployeeDTO> updateEmployee(@PathVariable Long id, @RequestBody EmployeeDTO employeeDTO) {
//        Employee employee = modelMapper.map(employeeDTO, Employee.class);
//        Employee updatedEmployee = employeeService.updateEmployee(id, employee);
//        EmployeeDTO updatedEmployeeDTO = modelMapper.map(updatedEmployee, EmployeeDTO.class);
//        return ResponseEntity.ok(updatedEmployeeDTO);
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
//        employeeService.deleteEmployee(id);
//        return ResponseEntity.noContent().build();
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable Long id) {
//        Employee employee = employeeService.getEmployeeById(id);
//        EmployeeDTO employeeDTO = modelMapper.map(employee, EmployeeDTO.class);
//        return ResponseEntity.ok(employeeDTO);
//    }
//
//    @GetMapping
//    public ResponseEntity<List<EmployeeDTO>> getAllEmployees() {
//        List<Employee> employees = employeeService.getAllEmployees();
//        List<EmployeeDTO> employeeDTOs = employees.stream()
//                .map(employee -> modelMapper.map(employee, EmployeeDTO.class))
//                .collect(Collectors.toList());
//        return ResponseEntity.ok(employeeDTOs);
//    }
//	
//}
////    @Autowired
////    private IEmployeeService employeeService;
////
////    @PostMapping
////    public ResponseEntity<EmployeeDTO> createEmployee(@RequestBody EmployeeDTO employeeDTO) {
////        Employee employee = convertToEntity(employeeDTO);
////        Employee savedEmployee = employeeService.saveEmployee(employee);
////        EmployeeDTO savedEmployeeDTO = convertToDTO(savedEmployee);
////        return ResponseEntity.ok(savedEmployeeDTO);
////    }
////
////    @PutMapping("/{id}")
////    public ResponseEntity<EmployeeDTO> updateEmployee(@PathVariable Long id, @RequestBody EmployeeDTO employeeDTO) {
////        Employee employee = convertToEntity(employeeDTO);
////        Employee updatedEmployee = employeeService.updateEmployee(id, employee);
////        EmployeeDTO updatedEmployeeDTO = convertToDTO(updatedEmployee);
////        return ResponseEntity.ok(updatedEmployeeDTO);
////    }
////
////    @DeleteMapping("/{id}")
////    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
////        employeeService.deleteEmployee(id);
////        return ResponseEntity.noContent().build();
////    }
////
////    @GetMapping("/{id}")
////    public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable Long id) {
////        Employee employee = employeeService.getEmployeeById(id);
////        EmployeeDTO employeeDTO = convertToDTO(employee);
////        return ResponseEntity.ok(employeeDTO);
////    }
////
////    @GetMapping
////    public ResponseEntity<List<EmployeeDTO>> getAllEmployees() {
////        List<Employee> employees = employeeService.getAllEmployees();
////        List<EmployeeDTO> employeeDTOs = employees.stream()
////                .map(this::convertToDTO)
////                .collect(Collectors.toList());
////        return ResponseEntity.ok(employeeDTOs);
////    }
////
////    // Helper methods to convert between Employee and EmployeeDTO
////    private EmployeeDTO convertToDTO(Employee employee) {
////        return new EmployeeDTO(employee.getId(), employee.getName(), employee.getRole(), employee.getDepartment());
////    }
////
////    private Employee convertToEntity(EmployeeDTO employeeDTO) {
////        return new Employee(employeeDTO.getId(), employeeDTO.getName(), employeeDTO.getRole(), employeeDTO.getDepartment());
////    }
