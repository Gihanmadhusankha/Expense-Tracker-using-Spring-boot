package com.projects.Expense.Tracker.services.expense;

import com.projects.Expense.Tracker.dto.ExpenseDTO;
import com.projects.Expense.Tracker.entity.Expense;

import java.util.List;

public interface ExpenseService {
    Expense postExpense(ExpenseDTO expenseDTO);
    List<Expense> getAllExpenses();
    Expense getExpenseById(Long id);
    Expense updateExpense(Long id, ExpenseDTO expenseDTO);
    void deleteExpense(Long id);
}
