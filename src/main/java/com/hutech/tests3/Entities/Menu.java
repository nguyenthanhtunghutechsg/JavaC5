package com.hutech.tests3.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String menu_id;
    private String name;
    private String URL;
    @ManyToOne
    private Menu parent;
    @OneToMany(mappedBy = "parent")
    @JsonBackReference
    private List<Menu> children;

}
