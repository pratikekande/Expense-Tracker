package org.example.expensetracker.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "transactions")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private double amount;

    private String type; // "INCOME" or "EXPENSE"

    private LocalDate transactionDate;

    private String note;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    // No-arg constructor
    public Transaction() {}

    // All-arg constructor
    public Transaction(Long id, String title, double amount, String type,
                       LocalDate transactionDate, String note, Category category) {
        this.id = id;
        this.title = title;
        this.amount = amount;
        this.type = type;
        this.transactionDate = transactionDate;
        this.note = note;
        this.category = category;
    }

    // Getters
    public Long getId() { return id; }
    public String getTitle() { return title; }
    public double getAmount() { return amount; }
    public String getType() { return type; }
    public LocalDate getTransactionDate() { return transactionDate; }
    public String getNote() { return note; }
    public Category getCategory() { return category; }

    // Setters
    public void setId(Long id) { this.id = id; }
    public void setTitle(String title) { this.title = title; }
    public void setAmount(double amount) { this.amount = amount; }
    public void setType(String type) { this.type = type; }
    public void setTransactionDate(LocalDate transactionDate) { this.transactionDate = transactionDate; }
    public void setNote(String note) { this.note = note; }
    public void setCategory(Category category) { this.category = category; }

    @Override
    public String toString() {
        return "Transaction{id=" + id + ", title='" + title + "', amount=" + amount +
                ", type='" + type + "', transactionDate=" + transactionDate + "}";
    }
}