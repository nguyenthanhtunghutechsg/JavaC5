package com.hutech.tests3.Services;


import com.hutech.tests3.Entities.Category;
import com.hutech.tests3.Entities.Product;
import com.hutech.tests3.Repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getCategorys() {
        return categoryRepository.findAll();
    }
    public Category saveCategory(Category category) {
        return categoryRepository.save(category);
    }
}
