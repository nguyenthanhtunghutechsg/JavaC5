package com.hutech.ngay3c5.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Classroom {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String class_id;
    private String name;
    @OneToMany(mappedBy = "classroom")
    private List<Student> students;
}
