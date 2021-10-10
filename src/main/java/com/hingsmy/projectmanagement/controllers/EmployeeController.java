package com.hingsmy.projectmanagement.controllers;

import com.hingsmy.projectmanagement.entities.Employee;
import com.hingsmy.projectmanagement.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {



    @Autowired
    EmployeeService empServer;

    @GetMapping
    public String displayEmployees(Model model) {
        List<Employee> employees = empServer.getAll();
        model.addAttribute("employees", employees);
        return "employees/list-employees";
    }

    @GetMapping("/new")
    public String displayEmployeeForm(Model model) {

        Employee anEmployee = new Employee();
        model.addAttribute("employee", anEmployee);
        return "employees/new-employee";
    }

    @PostMapping("/save")
    public String createEmployee(Employee employee, Model model) {
        // this should handle saving to the database
        empServer.save(employee);

        // use a redirect to prevent duplicate submissions
        return "redirect:/employees/new";
    }
}
