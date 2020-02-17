package com.nix.spring.test.controller;

import com.nix.spring.test.entity.Employee;
import com.nix.spring.test.service.EmployeeDataService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@RestController
@RequestMapping("api/employee")
public class HelloWorldController {

    private EmployeeDataService employeeDataService;

    @Autowired
    public HelloWorldController(EmployeeDataService employeeDataService) {
        this.employeeDataService = employeeDataService;
    }

    @PostMapping("/hello-world")
    public HelloWorldResponse helloWorld(@RequestBody HelloWorldRequest request){
        System.out.println(request.text);
        return new HelloWorldResponse();
    }

    @PostMapping("/write-emp")
    public void writeEmployee(@RequestBody HttpServletRequest request){
        Employee employee = new Employee(Long.parseLong(request.getParameter("employeeId")),request.getParameter("name"));
        System.out.printf("id = %s%n, name = %s%n", employee.getEmployeeId(), employee.getName());
        employeeDataService.putEmployee(employee);
    }

    @PostMapping
    public void writeeMployee(@RequestBody Employee employee){
        employeeDataService.putEmployee(employee);
    }

    @GetMapping
    public List<Employee> getEmployees(){
        return employeeDataService.getAllEmployees();
    }

    @Data
    private static class HelloWorldResponse {
        private String text = "Hello world";
    }

    @Data
    public static class HelloWorldRequest{
        private String text;
    }
}
