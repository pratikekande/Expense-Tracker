package org.example.expensetracker.controller;

import org.example.expensetracker.entity.Budget;
import org.example.expensetracker.service.BudgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/budgets")
public class BudgetController {

    @Autowired
    private BudgetService budgetService;

    // Show all budgets
    @GetMapping
    public String getAllBudgets(Model model) {
        model.addAttribute("budgets", budgetService.getAllBudgets());
        return "budgets/list";
    }

    // Show add budget form
    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("budget", new Budget());
        return "budgets/add";
    }

    // Save budget
    @PostMapping("/save")
    public String saveBudget(@ModelAttribute Budget budget) {
        budgetService.saveBudget(budget);
        return "redirect:/budgets";
    }

    // Delete budget
    @GetMapping("/delete/{id}")
    public String deleteBudget(@PathVariable Long id) {
        budgetService.deleteBudget(id);
        return "redirect:/budgets";
    }
}