package org.example.expensetracker.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "budgets")
public class Budget {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String categoryName;

    private double monthlyLimit;

    private int month;

    private int year;

    // No-arg constructor
    public Budget() {}

    // All-arg constructor
    public Budget(Long id, String categoryName, double monthlyLimit, int month, int year) {
        this.id = id;
        this.categoryName = categoryName;
        this.monthlyLimit = monthlyLimit;
        this.month = month;
        this.year = year;
    }

    // Getters
    public Long getId() { return id; }
    public String getCategoryName() { return categoryName; }
    public double getMonthlyLimit() { return monthlyLimit; }
    public int getMonth() { return month; }
    public int getYear() { return year; }

    // Setters
    public void setId(Long id) { this.id = id; }
    public void setCategoryName(String categoryName) { this.categoryName = categoryName; }
    public void setMonthlyLimit(double monthlyLimit) { this.monthlyLimit = monthlyLimit; }
    public void setMonth(int month) { this.month = month; }
    public void setYear(int year) { this.year = year; }

    @Override
    public String toString() {
        return "Budget{id=" + id + ", categoryName='" + categoryName +
                "', monthlyLimit=" + monthlyLimit + ", month=" + month + ", year=" + year + "}";
    }
}
