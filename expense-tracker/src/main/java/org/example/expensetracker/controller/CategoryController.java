package org.example.expensetracker.controller;

import org.example.expensetracker.entity.Category;
import org.example.expensetracker.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    // Show all categories
    @GetMapping
    public String getAllCategories(Model model) {
        model.addAttribute("categories", categoryService.getAllCategories());
        return "categories/list";
    }

    // Show add category form
    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("category", new Category());
        return "categories/add";
    }

    // Save category
    @PostMapping("/save")
    public String saveCategory(@ModelAttribute Category category) {
        categoryService.saveCategory(category);
        return "redirect:/categories";
    }

    // Delete category
    @GetMapping("/delete/{id}")
    public String deleteCategory(@PathVariable Long id) {
        categoryService.deleteCategory(id);
        return "redirect:/categories";
    }
}