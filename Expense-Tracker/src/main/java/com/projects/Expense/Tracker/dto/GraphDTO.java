package com.projects.Expense.Tracker.dto;

import com.projects.Expense.Tracker.entity.Expense;
import com.projects.Expense.Tracker.entity.Income;
import lombok.Data;

import java.util.List;

@Data
public class GraphDTO {
    private List<Expense> expenseList;
     private List<Income> incomeList;
}
