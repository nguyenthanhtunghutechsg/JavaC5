package com.hutech.ngay3c5.Controllers.Student;

import com.hutech.ngay3c5.Entities.Student;
import com.hutech.ngay3c5.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentService studentService;
    @GetMapping("")
    public String ShowAllStudents(Model model){
        List<Student> students = studentService.getAllStudents();
        model.addAttribute("students", students);
        return "Student/index";
    }
}
