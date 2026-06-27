package org.example.expensetracker.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "savings_goals")
public class SavingsGoal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String goalName;

    private double targetAmount;

    private double currentAmount;

    private LocalDate targetDate;

    // No-arg constructor
    public SavingsGoal() {}

    // All-arg constructor
    public SavingsGoal(Long id, String goalName, double targetAmount,
                       double currentAmount, LocalDate targetDate) {
        this.id = id;
        this.goalName = goalName;
        this.targetAmount = targetAmount;
        this.currentAmount = currentAmount;
        this.targetDate = targetDate;
    }

    // Getters
    public Long getId() { return id; }
    public String getGoalName() { return goalName; }
    public double getTargetAmount() { return targetAmount; }
    public double getCurrentAmount() { return currentAmount; }
    public LocalDate getTargetDate() { return targetDate; }

    // Setters
    public void setId(Long id) { this.id = id; }
    public void setGoalName(String goalName) { this.goalName = goalName; }
    public void setTargetAmount(double targetAmount) { this.targetAmount = targetAmount; }
    public void setCurrentAmount(double currentAmount) { this.currentAmount = currentAmount; }
    public void setTargetDate(LocalDate targetDate) { this.targetDate = targetDate; }

    @Override
    public String toString() {
        return "SavingsGoal{id=" + id + ", goalName='" + goalName +
                "', targetAmount=" + targetAmount + ", currentAmount=" + currentAmount + "}";
    }
}
