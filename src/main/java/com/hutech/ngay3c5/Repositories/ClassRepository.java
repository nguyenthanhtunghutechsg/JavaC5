package com.hutech.ngay3c5.Repositories;

import com.hutech.ngay3c5.Entities.Classroom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassRepository extends JpaRepository<Classroom,String> {
}
