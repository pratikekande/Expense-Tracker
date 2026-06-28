package org.example.expensetracker.controller;

import org.example.expensetracker.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ReportsController {

    @Autowired
    private TransactionService transactionService;

    @GetMapping("/reports")
    public String showReports(Model model) {
        model.addAttribute("transactions", transactionService.getAllTransactions());
        model.addAttribute("totalIncome", transactionService.getTotalIncome());
        model.addAttribute("totalExpense", transactionService.getTotalExpense());
        model.addAttribute("balance", transactionService.getBalance());
        return "reports/index";
    }
}