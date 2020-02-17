package com.nix.spring.test.repository;

import com.nix.spring.test.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("interface")
public interface EmployeeDao extends JpaRepository<Employee, Long> {
    int saveEmployee(Employee employee);
    List<Employee> getAllEmployees();
}
