package com.hutech.ngay3c5.Services;

import com.hutech.ngay3c5.Entities.Classroom;
import com.hutech.ngay3c5.Entities.Student;
import com.hutech.ngay3c5.Repositories.ClassRepository;
import com.hutech.ngay3c5.Repositories.StudentRepository;
import com.hutech.ngay3c5.RequestEntities.RequestCreateStudent;
import com.hutech.ngay3c5.RequestEntities.RequestUpdateStudent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private ClassServices classServices;

    public Student CreateStudent(RequestCreateStudent requestCreateStudent){
        try {
            Student student = new Student();
            student.setFirstName(requestCreateStudent.getFirstName());
            student.setLastName(requestCreateStudent.getLastName());
            student.setEmail(requestCreateStudent.getEmail());
            student.setPassword(requestCreateStudent.getPassword());
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date date = dateFormat.parse(requestCreateStudent.getDateOfBirth());
            student.setDateOfBirth(date);
            student.setAge((new Date()).getYear()-date.getYear());
            student.setClassroom(requestCreateStudent.getClassroom());
            studentRepository.save(student);
            return student;
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }
    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }
    public Student getStudentById(String id){
        return studentRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Student with id " + id + " not found")
        );
    }
    public Student updateStudent(String id,RequestUpdateStudent requestUpdateStudent){
        try {
            Student student = getStudentById(id);
            student.setFirstName(requestUpdateStudent.getFirstName());
            student.setLastName(requestUpdateStudent.getLastName());
            student.setPassword(requestUpdateStudent.getPassword());
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date date = dateFormat.parse(requestUpdateStudent.getDateOfBirth());
            student.setDateOfBirth(date);
            student.setAge((new Date()).getYear()-date.getYear());
            return studentRepository.save(student);
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }

}
