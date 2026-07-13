package com.infosys.userservice.repo;

import com.infosys.userservice.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    // Find employee by employee code
    Optional<Employee> findByEmployeeCode(String employeeCode);

    // Find employee by email
    Optional<Employee> findByEmail(String email);

    // Find employees by department
    List<Employee> findByDepartment(String department);

    // Find employees by designation
    List<Employee> findByDesignation(String designation);

    // Find employees by status
    List<Employee> findByStatus(String status);

    // Check if email already exists
    boolean existsByEmail(String email);

    // Check if employee code already exists
    boolean existsByEmployeeCode(String employeeCode);

}