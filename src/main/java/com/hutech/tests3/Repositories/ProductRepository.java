package com.hutech.tests3.Repositories;

import com.hutech.tests3.Entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, String > {
    @Query("select p from Product p where concat(p.name,p.brand,p.gpu,p.cpu,p.ram,p.disk,p.screen) like %?1% ")
    List<Product> search(String keyword);
}
