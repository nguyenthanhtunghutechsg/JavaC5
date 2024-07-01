package com.hutech.tests3.Controllers.API;

import com.hutech.tests3.Entities.Product;
import com.hutech.tests3.Services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductRestController {
    @Autowired
    private ProductService productService;
    @GetMapping("")
    @CrossOrigin
    public List<Product> getProducts() {
        return productService.getProducts();
    }
    @GetMapping("/search")
    @CrossOrigin
    public List<Product> SearchProducts(@RequestParam(name="q",required = false)
                                            String q) {
        return productService.searchProduct(q);
    }

}
