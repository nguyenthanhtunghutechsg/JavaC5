package com.hutech.tests3.Controllers;

import com.hutech.tests3.Entities.Category;
import com.hutech.tests3.Services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("categories")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @GetMapping("")
    public String Index(Model model){
        List<Category> listCate = categoryService.getCategorys();
        model.addAttribute("categories", listCate);
        return "Layout/Category/index";
    }
    @GetMapping("/new")
    public String newCategory(Model model){
        model.addAttribute("category", new Category());
        return "Layout/Category/new";
    }
    @PostMapping("/new")
    public String saveCategory(Category category){
        categoryService.saveCategory(category);
        return "redirect:/categories";
    }

}
