package com.FanYakul.pma.controllers;

import com.FanYakul.pma.dao.ProjectRepository;
import com.FanYakul.pma.dao.StudentRepository;
import com.FanYakul.pma.dto.ChartData;
import com.FanYakul.pma.dto.StudentProject;
import com.FanYakul.pma.entities.Project;
import com.FanYakul.pma.entities.Student;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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
    private String version;

    @Autowired
    ProjectRepository projectRepository;

    @Autowired
    StudentRepository studentRepository;

    @GetMapping("/")
    public String displayHome(Model model) throws JsonProcessingException {

//        Map<String,Object> map=new HashMap<>();

        model.addAttribute("versionNumber",version);

        List<Project> projects = projectRepository.findAll();
        model.addAttribute("Projects",projects);

        List<ChartData> projectStatusData = projectRepository.getProjectStatus();
        ObjectMapper objectMapper = new ObjectMapper();
//      ObjectMapper.writeValueAsString(projectStatusData);
        String jsonString =objectMapper.writeValueAsString(projectStatusData);
        model.addAttribute("projectStatusData",jsonString);

        List<StudentProject> studentsProjects =studentRepository.studentProjects();
        model.addAttribute("studentProjects",studentsProjects);

        return "main/home";
    }
}
