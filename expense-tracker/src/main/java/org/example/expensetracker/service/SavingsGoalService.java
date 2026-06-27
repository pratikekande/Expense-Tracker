package org.example.expensetracker.service;

import org.example.expensetracker.entity.SavingsGoal;
import org.example.expensetracker.repository.SavingsGoalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SavingsGoalService {

    @Autowired
    private SavingsGoalRepository savingsGoalRepository;

    // Get all goals
    public List<SavingsGoal> getAllGoals() {
        return savingsGoalRepository.findAll();
    }

    // Get goal by id
    public SavingsGoal getGoalById(Long id) {
        return savingsGoalRepository.findById(id).orElse(null);
    }

    // Save or update goal
    public void saveGoal(SavingsGoal goal) {
        savingsGoalRepository.save(goal);
    }

    // Delete goal
    public void deleteGoal(Long id) {
        savingsGoalRepository.deleteById(id);
    }

    // Update progress - add amount to current savings
    public void updateProgress(Long id, double amount) {
        SavingsGoal goal = savingsGoalRepository.findById(id).orElse(null);
        if (goal != null) {
            goal.setCurrentAmount(goal.getCurrentAmount() + amount);
            savingsGoalRepository.save(goal);
        }
    }

    // Get progress percentage
    public double getProgressPercentage(SavingsGoal goal) {
        if (goal.getTargetAmount() == 0) return 0;
        return (goal.getCurrentAmount() / goal.getTargetAmount()) * 100;
    }
}