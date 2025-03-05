package com.projects.Expense.Tracker.dto;

import com.projects.Expense.Tracker.entity.Expense;
import com.projects.Expense.Tracker.entity.Income;
import lombok.Data;

@Data
public class StatsDTO {
    private Double Income;
    private Double Expense;

    private Income latestIncome;
    private Expense latestExpense;

    private Double balance;
    private Double minIncome;
    private Double maxIncome;
    private Double minExpense;
    private Double maxExpense;


}
