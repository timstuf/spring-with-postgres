package com.nix.spring.test.service;

import com.nix.spring.test.entity.Employee;
import com.nix.spring.test.repository.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeDataService {
    private EmployeeDao employeeDao;

    @Autowired
    public EmployeeDataService( @Qualifier("interface") EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }


    @Transactional
    public void putEmployee(Employee employee) {
      employeeDao.save(employee);
    }

    @Transactional
    public List<Employee> getAllEmployees(){
        return employeeDao.findAll();
    }

}
