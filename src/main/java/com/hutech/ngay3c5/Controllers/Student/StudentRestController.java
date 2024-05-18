package com.hutech.ngay3c5.Controllers.Student;

import com.hutech.ngay3c5.Entities.Student;
import com.hutech.ngay3c5.RequestEntities.RequestCreateStudent;
import com.hutech.ngay3c5.RequestEntities.RequestUpdateStudent;
import com.hutech.ngay3c5.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/students")
public class StudentRestController {
    @Autowired
    private StudentService studentService;

    @PostMapping("")
    public Student CreateStudent(@RequestBody RequestCreateStudent requestCreateStudent) {
        return studentService.CreateStudent(requestCreateStudent);
    }
    @GetMapping("")
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }
    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable String id) {
        return studentService.getStudentById(id);
    }
    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable String id, @RequestBody RequestUpdateStudent requestUpdateStudent) {
        return studentService.updateStudent(id, requestUpdateStudent);
    }
}
