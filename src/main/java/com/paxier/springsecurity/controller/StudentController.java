package com.paxier.springsecurity.controller;

import com.paxier.springsecurity.model.Student;
import com.paxier.springsecurity.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/students")
@Slf4j
public class StudentController {

    private final List<Student> students = new ArrayList<>(List.of (new Student(1, "John Doe", "Math"), new Student(2, "Mary John", "English")));

    public StudentController(StudentService studentService) {
    }

    @GetMapping
    public List<Student> getStudents() {
        return students;
    }

    @PostMapping
    public void registerNewStudent(@RequestBody Student student) {
        students.add(student);
        log.debug("Student added: {}", student);
    }
}
