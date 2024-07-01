package com.hutech.tests3.Services;


import com.hutech.tests3.Entities.Product;
import com.hutech.tests3.Repositories.CategoryRepository;
import com.hutech.tests3.Repositories.ProductRepository;
import com.hutech.tests3.RequestEntities.CreateProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public int getMaxPrice(){
        return productRepository.getMaxPrice();
    }
    public int getMinPrice(){
        return productRepository.getMinPrice();
    }
    public List<String> getCPU(){
        return productRepository.getCPU();
    }
    public List<String> getGPU(){
        List<String> result = new ArrayList<String>();
        for (String gpu :  productRepository.getGPU()) {
            if (gpu.isEmpty()||gpu.equals("")||gpu.isBlank()) {
                result.add("khong gpu");
            }else{
                result.add(gpu);
            }
        }
        return result;
    }
    public List<String> getBrand(){
        return productRepository.getBrand();
    }
    public List<Product> getByFilter(Integer maxPrice, Integer minPrice
    ,List<String> cpus,List<String> gpus,List<String> brands ){
        List<Product> allProduct = productRepository.findAll();
        List<Product> filterResult = allProduct.stream().filter(
                p->(maxPrice==null||p.getPrice()<=maxPrice)
        ).filter(
                p->(minPrice==null||p.getPrice()>=minPrice)
        ).filter(
                p->(cpus==null||cpus.contains(p.getCpu()))
        ).filter(
                p->(gpus==null||cpus.contains(p.getGpu()))
        ).filter(
                p->(brands==null||cpus.contains(p.getBrand()))
        ).toList();
        return filterResult;
    }
}
