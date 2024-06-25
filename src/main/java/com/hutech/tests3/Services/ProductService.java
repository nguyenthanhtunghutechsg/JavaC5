package com.hutech.tests3.Services;


import com.hutech.tests3.Entities.Product;
import com.hutech.tests3.Repositories.CategoryRepository;
import com.hutech.tests3.Repositories.ProductRepository;
import com.hutech.tests3.RequestEntities.CreateProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    public List<Product> getProducts() {
        return productRepository.findAll();
    }
    public Product saveProduct(Product product) {
//        Product product = new Product();
//        product.setName(createProduct.getName());
//        product.setDescription(createProduct.getDescription());
//        product.setPrice(createProduct.getPrice());
//        product.setGpu(createProduct.getGpu());
//        product.setCpu(createProduct.getCpu());
//        product.setRam(createProduct.getRam());
//        product.setDisk(createProduct.getDisk());
//        product.setBrand(createProduct.getBrand());
//        product.setScreen(createProduct.getScreen());
//        product.setCategory(createProduct.getRam());

        return productRepository.save(product);
    }
    public List<Product> searchProduct(String keyword) {
        return productRepository.search(keyword);
    }
}
