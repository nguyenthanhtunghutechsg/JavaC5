package com.hutech.ngay3c5.Services;

import com.hutech.ngay3c5.Entities.Classroom;
import com.hutech.ngay3c5.Repositories.ClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassServices {
    @Autowired
    private ClassRepository classRepository;
    public List<Classroom> getAllClasses() {
        return classRepository.findAll();
    }
    public Classroom getClassById(String id) {
        return classRepository.findById(id).orElseThrow(
                ()-> new RuntimeException("Class not found")
        );
    }
    public Classroom createClassroom(Classroom classroom) {
        return classRepository.save(classroom);
    }
}
