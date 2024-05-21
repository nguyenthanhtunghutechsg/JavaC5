package com.hutech.ngay3c5.Controllers.Classroom;

import com.hutech.ngay3c5.Entities.Classroom;
import com.hutech.ngay3c5.Services.ClassServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/classrooms")
public class ClassroomController {
    @Autowired
    private ClassServices classServices;
    @GetMapping("")
    public List<Classroom> getAllClassrooms(){
        return classServices.getAllClasses();
    }
    @PostMapping("")
    public Classroom createClassroom(@RequestBody Classroom classroom) {
        return classServices.createClassroom(classroom);
    }
}
