package org.example.expensetracker.controller;

import org.example.expensetracker.entity.Transaction;
import org.example.expensetracker.service.CategoryService;
import org.example.expensetracker.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @Autowired
    private CategoryService categoryService;

    // Show all transactions
    @GetMapping
    public String getAllTransactions(Model model) {
        model.addAttribute("transactions", transactionService.getAllTransactions());
        return "transactions/list";
    }

    // Show add transaction form
    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("transaction", new Transaction());
        model.addAttribute("categories", categoryService.getAllCategories());
        return "transactions/add";
    }

    // Save transaction
    @PostMapping("/save")
    public String saveTransaction(@ModelAttribute Transaction transaction) {
        transactionService.saveTransaction(transaction);
        return "redirect:/transactions";
    }

    // Show edit transaction form
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        model.addAttribute("transaction", transactionService.getTransactionById(id));
        model.addAttribute("categories", categoryService.getAllCategories());
        return "transactions/edit";
    }

    // Update transaction
    @PostMapping("/update/{id}")
    public String updateTransaction(@PathVariable Long id, @ModelAttribute Transaction transaction) {
        transaction.setId(id);
        transactionService.saveTransaction(transaction);
        return "redirect:/transactions";
    }

    // Delete transaction
    @GetMapping("/delete/{id}")
    public String deleteTransaction(@PathVariable Long id) {
        transactionService.deleteTransaction(id);
        return "redirect:/transactions";
    }
}