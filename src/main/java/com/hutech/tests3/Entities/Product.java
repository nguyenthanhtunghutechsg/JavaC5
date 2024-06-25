package com.hutech.tests3.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String product_id;
    private String name;
    private String description;
    private long price;
    private String gpu;
    private String cpu;
    private int ram;
    private int disk;
    private float screen;
    private String brand;
    @ManyToOne
    @JoinColumn(name = "cate_id")
    private Category category;

}
