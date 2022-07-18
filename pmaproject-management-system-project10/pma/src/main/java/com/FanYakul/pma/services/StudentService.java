package com.FanYakul.pma.services;

import com.FanYakul.pma.dao.StudentRepository;
import com.FanYakul.pma.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public Student save(Student student){
        return studentRepository.save(student);
    }

    public List<Student> getAll(){
        return studentRepository.findAll();
    }

    public Student findByStudentId(long theId) {

        return studentRepository.findByStudentId(theId);
    }

    public void delete(Student theStudent) {

        studentRepository.delete(theStudent);
    }
}
