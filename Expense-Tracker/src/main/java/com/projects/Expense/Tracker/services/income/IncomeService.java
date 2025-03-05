package com.projects.Expense.Tracker.services.income;

import com.projects.Expense.Tracker.dto.IncomeDTO;
import com.projects.Expense.Tracker.entity.Income;

import java.util.List;

public interface IncomeService {
    Income postIncome(IncomeDTO incomeDTO);
    List<IncomeDTO> getAllIncome();
    IncomeDTO getIncomeById(Long id);
    Income updateIncome(Long id, IncomeDTO incomeDTO);

    void deleteIncome(Long id);
}
