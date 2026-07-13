package com.infosys.userservice.controller;

import com.infosys.userservice.dto.EmployeeDTO;
import com.infosys.userservice.service.EmployeeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class EmployeeController {

    private final EmployeeService employeeService = null;

    // Create Employee
    @PostMapping
    public ResponseEntity<EmployeeDTO> createEmployee(@Valid @RequestBody EmployeeDTO employeeDTO) {
        EmployeeDTO savedEmployee = employeeService.createEmployee(employeeDTO);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    // Get Employee by ID
    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable("id") Long employeeId) {
        return ResponseEntity.ok(employeeService.getEmployeeById(employeeId));
    }

    // Get Employee by Employee Code
    @GetMapping("/code/{employeeCode}")
    public ResponseEntity<EmployeeDTO> getEmployeeByEmployeeCode(
            @PathVariable String employeeCode) {

        return ResponseEntity.ok(
                employeeService.getEmployeeByEmployeeCode(employeeCode));
    }

    // Get All Employees
    @GetMapping
    public ResponseEntity<List<EmployeeDTO>> getAllEmployees() {
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

    // Get Employees by Department
    @GetMapping("/department/{department}")
    public ResponseEntity<List<EmployeeDTO>> getEmployeesByDepartment(
            @PathVariable String department) {

        return ResponseEntity.ok(
                employeeService.getEmployeesByDepartment(department));
    }

    // Get Employees by Designation
    @GetMapping("/designation/{designation}")
    public ResponseEntity<List<EmployeeDTO>> getEmployeesByDesignation(
            @PathVariable String designation) {

        return ResponseEntity.ok(
                employeeService.getEmployeesByDesignation(designation));
    }

    // Get Employees by Status
    @GetMapping("/status/{status}")
    public ResponseEntity<List<EmployeeDTO>> getEmployeesByStatus(
            @PathVariable String status) {

        return ResponseEntity.ok(
                employeeService.getEmployeesByStatus(status));
    }

    // Update Employee
    @PutMapping("/{id}")
    public ResponseEntity<EmployeeDTO> updateEmployee(
            @PathVariable("id") Long employeeId,
            @Valid @RequestBody EmployeeDTO employeeDTO) {

        return ResponseEntity.ok(
                employeeService.updateEmployee(employeeId, employeeDTO));
    }

    // Delete Employee
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long employeeId) {

        employeeService.deleteEmployee(employeeId);

        return ResponseEntity.ok("Employee deleted successfully.");
    }

}