package com.hutech.tests3.Controllers;

import com.hutech.tests3.Entities.Category;
import com.hutech.tests3.Entities.Product;
import com.hutech.tests3.RequestEntities.CreateProduct;
import com.hutech.tests3.Services.CategoryService;
import com.hutech.tests3.Services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("products")
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;
    @GetMapping("")
    public String Index(Model model){
        List<Product> listProduct = productService.getProducts();
        model.addAttribute("products", listProduct);
        return "Layout/Product/index";
    }
    @GetMapping("/new")
    public String newProduct(Model model){
        model.addAttribute("categories", categoryService.getCategorys());
        model.addAttribute("product", new Product());
        return "Layout/Product/new";
    }
    @PostMapping("/new")
    public String saveProduct(Product product){
        productService.saveProduct(product);
        return "redirect:/products";
    }
    @GetMapping("/search")
    public String searchProduct(@RequestParam(value = "q",required = false)String q, Model model){
        List<Product> listProduct ;
        if(q == ""||q==null){
            listProduct = productService.getProducts();
        }else{
            listProduct = productService.searchProduct(q);
        }
        model.addAttribute("products", listProduct);
        return "Layout/Product/search";
    }

}
