package com.hutech.tests3.RequestEntities;

import com.hutech.tests3.Entities.Category;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateProduct {

    private String name;
    private String description;
    private long price;
    private String gpu;
    private String cpu;
    private int ram;
    private int disk;
    private float screen;
    private String brand;
    private String category;

}