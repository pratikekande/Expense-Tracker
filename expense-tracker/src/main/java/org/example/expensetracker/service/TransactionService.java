package org.example.expensetracker.service;

import org.example.expensetracker.entity.Transaction;
import org.example.expensetracker.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    // Get all transactions
    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    // Get transaction by id
    public Transaction getTransactionById(Long id) {
        return transactionRepository.findById(id).orElse(null);
    }

    // Save or update transaction
    public void saveTransaction(Transaction transaction) {
        transactionRepository.save(transaction);
    }

    // Delete transaction
    public void deleteTransaction(Long id) {
        transactionRepository.deleteById(id);
    }

    // Get total income
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

    // Get total expense
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

    // Get current balance
    public double getBalance() {
        return getTotalIncome() - getTotalExpense();
    }
}