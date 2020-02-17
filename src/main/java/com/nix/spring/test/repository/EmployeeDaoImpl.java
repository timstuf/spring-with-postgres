package com.nix.spring.test.repository;

import com.nix.spring.test.entity.Employee;

import java.util.ArrayList;
import java.util.List;

//@Repository("impl")
public class EmployeeDaoImpl  {

    private static List<Employee> DB = new ArrayList<>();

   // @Override
    public int saveEmployee(Employee employee) {
        DB.add(employee);
        return 1;
    }

    //@Override
    public List<Employee> getAllEmployees() {
        return DB;
    }
}
