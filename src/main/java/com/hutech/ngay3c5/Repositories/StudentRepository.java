package com.hutech.ngay3c5.Repositories;

import com.hutech.ngay3c5.Entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,String> {
}
