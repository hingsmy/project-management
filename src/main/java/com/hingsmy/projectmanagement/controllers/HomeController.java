package com.hingsmy.projectmanagement.controllers;

import com.hingsmy.projectmanagement.dao.EmployeeRepository;
import com.hingsmy.projectmanagement.dao.ProjectRepository;
import com.hingsmy.projectmanagement.dto.EmployeeProject;
import com.hingsmy.projectmanagement.entities.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    ProjectRepository proRepo;

    @Autowired
    EmployeeRepository employeeRepo;

    @GetMapping("/")
    public String displayHome(Model model) {

        // query the database for projects
        List<Project> projects = proRepo.findAll();
        model.addAttribute("projectsList", projects);

        // query the database for employees
        List<EmployeeProject> employeeProjects = employeeRepo.employeeProjects();
        model.addAttribute("employeesListProjectsCnt", employeeProjects);

        return "main/home";
    }
}
