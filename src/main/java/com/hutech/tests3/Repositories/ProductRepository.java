package com.hutech.tests3.Repositories;

import com.hutech.tests3.Entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, String > {
    @Query("select p from Product p where concat(p.name,p.brand,p.gpu,p.cpu,p.ram,p.disk,p.screen) like %?1% ")
    List<Product> search(String keyword);
    @Query("select max(p.price) from Product p")
    int getMaxPrice();
    @Query("select min(p.price) from Product p")
    int getMinPrice();
    @Query("select p.cpu from Product p group by p.cpu")
    List<String> getCPU();
    @Query("select p.gpu from Product p group by p.gpu")
    List<String> getGPU();
    @Query("select p.brand from Product p group by p.brand")
    List<String> getBrand();

}
