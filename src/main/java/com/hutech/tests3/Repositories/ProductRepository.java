package com.hutech.tests3.Repositories;

import com.hutech.tests3.Entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, String > {
}
