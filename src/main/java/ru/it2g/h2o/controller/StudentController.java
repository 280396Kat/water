package ru.it2g.h2o.controller;

import lombok.RequiredArgsConstructor;
import org.apache.catalina.LifecycleState;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.it2g.h2o.entity.Student;
import ru.it2g.h2o.service.StudentService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class StudentController { //

    private final StudentService studentService;

    @GetMapping("/students")
    public List<Student> findAll() {
        return studentService.findAll();
    }

    @PostMapping("/save")
    public void save(@RequestBody Student student) {
        studentService.save(student);
    }
}
