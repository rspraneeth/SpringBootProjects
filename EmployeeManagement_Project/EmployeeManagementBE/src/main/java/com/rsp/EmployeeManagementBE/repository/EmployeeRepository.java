package com.rsp.EmployeeManagementBE.repository;

import com.rsp.EmployeeManagementBE.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
