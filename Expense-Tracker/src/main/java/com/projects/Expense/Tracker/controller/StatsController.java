package com.projects.Expense.Tracker.controller;

import com.projects.Expense.Tracker.dto.GraphDTO;
import com.projects.Expense.Tracker.services.stats.StatsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/stats")
@CrossOrigin("*")
@RequiredArgsConstructor
public class StatsController {
    private final StatsService statsService;

    @GetMapping("/chart")
     public ResponseEntity<GraphDTO> getChartDetails(){
        return ResponseEntity.ok(statsService.getChartData());
    }
    @GetMapping
    public ResponseEntity<?>getStats(){
        return ResponseEntity.ok(statsService.getStats());
    }
}
