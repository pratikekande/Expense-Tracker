package org.example.expensetracker.service;

import org.example.expensetracker.entity.Budget;
import org.example.expensetracker.repository.BudgetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BudgetService {

    @Autowired
    private BudgetRepository budgetRepository;

    // Get all budgets
    public List<Budget> getAllBudgets() {
        return budgetRepository.findAll();
    }

    // Get budget by id
    public Budget getBudgetById(Long id) {
        return budgetRepository.findById(id).orElse(null);
    }

    // Save or update budget
    public void saveBudget(Budget budget) {
        budgetRepository.save(budget);
    }

    // Delete budget
    public void deleteBudget(Long id) {
        budgetRepository.deleteById(id);
    }
}