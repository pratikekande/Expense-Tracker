package org.example.expensetracker.service;

import org.example.expensetracker.entity.Transaction;
import org.example.expensetracker.entity.Category;
import org.example.expensetracker.repository.TransactionRepository;
import org.example.expensetracker.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    public Transaction getTransactionById(Long id) {
        return transactionRepository.findById(id).orElse(null);
    }

    // ← THIS is the fixed method
    public void saveTransaction(Transaction transaction) {
        if (transaction.getCategory() != null && transaction.getCategory().getId() != null) {
            Category category = categoryRepository.findById(transaction.getCategory().getId()).orElse(null);
            transaction.setCategory(category);
        }
        transactionRepository.save(transaction);
    }

    public void deleteTransaction(Long id) {
        transactionRepository.deleteById(id);
    }

    public double getTotalIncome() {
        List<Transaction> transactions = transactionRepository.findAll();
        double total = 0;
        for (Transaction t : transactions) {
            if ("INCOME".equals(t.getType())) {
                total += t.getAmount();
            }
        }
        return total;
    }

    public double getTotalExpense() {
        List<Transaction> transactions = transactionRepository.findAll();
        double total = 0;
        for (Transaction t : transactions) {
            if ("EXPENSE".equals(t.getType())) {
                total += t.getAmount();
            }
        }
        return total;
    }

    public double getBalance() {
        return getTotalIncome() - getTotalExpense();
    }
}