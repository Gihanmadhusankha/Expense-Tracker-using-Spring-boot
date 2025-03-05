package com.projects.Expense.Tracker.services.stats;

import com.projects.Expense.Tracker.dto.GraphDTO;
import com.projects.Expense.Tracker.dto.StatsDTO;

public interface StatsService {
    GraphDTO getChartData();
    StatsDTO getStats();
}
