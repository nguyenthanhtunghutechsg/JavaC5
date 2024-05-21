package com.hutech.ngay3c5.Controllers.Student;

import com.hutech.ngay3c5.Entities.Classroom;
import com.hutech.ngay3c5.Entities.Student;
import com.hutech.ngay3c5.RequestEntities.RequestCreateStudent;
import com.hutech.ngay3c5.RequestEntities.RequestUpdateStudent;
import com.hutech.ngay3c5.Services.ClassServices;
import com.hutech.ngay3c5.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private ClassServices classServices;
    @GetMapping("")
    public String ShowAllStudents(Model model){
        List<Student> students = studentService.getAllStudents();
        model.addAttribute("students", students);
        return "Student/index";
    }
    @GetMapping("/edit/{id}")
    public String ShowStudentForm(@PathVariable String id, Model model){
        Student student = studentService.getStudentById(id);
        model.addAttribute("student", student);
        return "Student/edit";
    }
    @PostMapping("/saveedit")
    public String SaveEditStudent(RequestUpdateStudent requestUpdateStudent){
        studentService.updateStudent(requestUpdateStudent.getId(),requestUpdateStudent);
        return "redirect:/students";
    }
    @GetMapping("/new")
    public String createForm(Model model){
        Student student = new Student();
        List<Classroom> classrooms = classServices.getAllClasses();
        model.addAttribute("student", student);
        model.addAttribute("classes", classrooms);
        return "Student/create";
    }
    @PostMapping("/create")
    public String SaveCreateStudent(RequestCreateStudent requestCreateStudent){
        studentService.CreateStudent(requestCreateStudent);
        return "redirect:/students";
    }
}
