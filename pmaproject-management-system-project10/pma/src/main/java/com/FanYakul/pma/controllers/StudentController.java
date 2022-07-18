package com.FanYakul.pma.controllers;

import com.FanYakul.pma.dao.StudentRepository;
import com.FanYakul.pma.entities.Student;
import com.FanYakul.pma.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("students")
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping
    public String displayStudents(Model model){

       List<Student> students=studentService.getAll();
        model.addAttribute("students",students);
        return "students/list-students";
    }

    @GetMapping("/new")
    public String displayStudentForm(Model model){

        Student aStudent=new Student();
        model.addAttribute("student",aStudent);
        return "students/new-student";
    }

    @PostMapping("/save")
    public String createStudent(Model model, @Valid Student student, Errors errors){

        if (errors.hasErrors()) return "students/new-student";

        studentService.save(student);
        return "redirect:/students";
    }

    @GetMapping("/update")
    public String displayStudentUpdateForm(@RequestParam("id") long theId,Model model){

        Student theStudent = studentService.findByStudentId(theId);
        model.addAttribute("student",theStudent);
        return "students/new-student";
    }

    @GetMapping("/delete")
    public String deleteStudent(@RequestParam("id") long theId, Model model){

        Student theStudent = studentService.findByStudentId(theId);
        studentService.delete(theStudent);
        return "redirect:/students";
    }
}
