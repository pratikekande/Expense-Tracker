package org.example.expensetracker.controller;

import org.example.expensetracker.entity.SavingsGoal;
import org.example.expensetracker.service.SavingsGoalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/goals")
public class SavingsGoalController {

    @Autowired
    private SavingsGoalService savingsGoalService;

    // Show all goals
    @GetMapping
    public String getAllGoals(Model model) {
        model.addAttribute("goals", savingsGoalService.getAllGoals());
        return "goals/list";
    }

    // Show add goal form
    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("goal", new SavingsGoal());
        return "goals/add";
    }

    // Save goal
    @PostMapping("/save")
    public String saveGoal(@ModelAttribute SavingsGoal goal) {
        savingsGoalService.saveGoal(goal);
        return "redirect:/goals";
    }

    // Show update progress form
    @GetMapping("/update/{id}")
    public String showUpdateForm(@PathVariable Long id, Model model) {
        model.addAttribute("goal", savingsGoalService.getGoalById(id));
        return "goals/update";
    }

    // Update progress
    @PostMapping("/update/{id}")
    public String updateProgress(@PathVariable Long id, @RequestParam double amount) {
        savingsGoalService.updateProgress(id, amount);
        return "redirect:/goals";
    }

    // Delete goal
    @GetMapping("/delete/{id}")
    public String deleteGoal(@PathVariable Long id) {
        savingsGoalService.deleteGoal(id);
        return "redirect:/goals";
    }
}