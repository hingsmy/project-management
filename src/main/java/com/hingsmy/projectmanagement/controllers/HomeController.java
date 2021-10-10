package com.hingsmy.projectmanagement.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hingsmy.projectmanagement.dao.EmployeeRepository;
import com.hingsmy.projectmanagement.dao.ProjectRepository;
import com.hingsmy.projectmanagement.dto.ChartData;
import com.hingsmy.projectmanagement.dto.EmployeeProject;
import com.hingsmy.projectmanagement.entities.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class HomeController {

    @Value("${version}")
    private String ver;

    @Autowired
    ProjectRepository proRepo;

    @Autowired
    EmployeeRepository employeeRepo;

    @GetMapping("/")
    public String displayHome(Model model) throws JsonProcessingException {

        model.addAttribute("versionNumber", ver);

        Map<String, Object> map = new HashMap<>();

        // query the database for projects
        List<Project> projects = proRepo.findAll();
        model.addAttribute("projectsList", projects);

        List<ChartData> projectData = proRepo.getProjectStatus();

        // Let's convert projectData object into a json structure for use in javascript
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonString = objectMapper.writeValueAsString(projectData);

        model.addAttribute("projectStatusCnt", jsonString);


        // query the database for employees
        List<EmployeeProject> employeeProjects = employeeRepo.employeeProjects();
        model.addAttribute("employeesListProjectsCnt", employeeProjects);

        return "main/home";
    }
}
