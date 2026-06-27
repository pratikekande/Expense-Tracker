package org.example.expensetracker.controller;

import org.example.expensetracker.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {

    @Autowired
    private TransactionService transactionService;

    @GetMapping("/")
    public String redirectToDashboard() {
        return "redirect:/dashboard";
    }

    @GetMapping("/dashboard")
    public String showDashboard(Model model) {
        double totalIncome = transactionService.getTotalIncome();
        double totalExpense = transactionService.getTotalExpense();
        double balance = transactionService.getBalance();
        double savings = balance - totalExpense;

        model.addAttribute("totalIncome", totalIncome);
        model.addAttribute("totalExpense", totalExpense);
        model.addAttribute("balance", balance);
        model.addAttribute("savings", savings);
        model.addAttribute("recentTransactions", transactionService.getAllTransactions());

        return "dashboard";
    }
}