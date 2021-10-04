package com.hingsmy.projectmanagement.controllers;

import com.hingsmy.projectmanagement.dao.EmployeeRepository;
import com.hingsmy.projectmanagement.dao.ProjectRepository;
import com.hingsmy.projectmanagement.entities.Employee;
import com.hingsmy.projectmanagement.entities.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/projects")
public class ProjectController {

    @Autowired
    ProjectRepository proRepo;

    @Autowired
    EmployeeRepository employeeRepo;

    @GetMapping
    public String displayProjects(Model model) {
        List<Project> projects = proRepo.findAll();
        model.addAttribute("projects", projects);
        return "projects/list-projects";
    }

    @GetMapping("/new")
    public String displayProjectForm(Model model) {

        Project aProject = new Project();
        List<Employee> employees = employeeRepo.findAll();

        model.addAttribute("project", aProject);
        model.addAttribute("allEmployees", employees);
        return "projects/new-project";
    }

    @PostMapping("/save")
    public String createProject(Project project, @RequestParam List<Long> employees, Model model) {
        // this should handle saving to the database
        proRepo.save(project);

        Iterable<Employee> chosenEmployees = employeeRepo.findAllById(employees);

        for (Employee emp : chosenEmployees) {
            emp.setProject(project);
            employeeRepo.save(emp);
        }

        // use a redirect to prevent duplicate submissions
        return "redirect:/projects/new";
    }
}
