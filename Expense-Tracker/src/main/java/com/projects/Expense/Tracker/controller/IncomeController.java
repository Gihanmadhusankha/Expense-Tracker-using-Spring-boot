package com.projects.Expense.Tracker.controller;

import com.projects.Expense.Tracker.dto.IncomeDTO;
import com.projects.Expense.Tracker.entity.Income;
import com.projects.Expense.Tracker.services.income.IncomeService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/income")
@RequiredArgsConstructor
@CrossOrigin("*")
public class IncomeController {
    @Autowired
    private  IncomeService incomeService;

    @PostMapping("/post")
    public ResponseEntity<?> postIncome(@RequestBody IncomeDTO incomeDTO) {
        Income createIncome = incomeService.postIncome(incomeDTO);
        if (createIncome != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(createIncome);

        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();

        }
    }
    @GetMapping("/all")
    public ResponseEntity<?>getAllIncome(){
        return ResponseEntity.ok(incomeService.getAllIncome());
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> updateExpense(@PathVariable Long id, @RequestBody IncomeDTO incomeDTO) {
        try {
            return ResponseEntity.ok(incomeService.updateIncome(id, incomeDTO));
        } catch (EntityNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong");
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getIncomeById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(incomeService.getIncomeById(id));
        } catch (EntityNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong");
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteIncome(@PathVariable Long id) {
        try {
            incomeService.deleteIncome(id);
            return ResponseEntity.ok(null);
        } catch (EntityNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong");
        }
    }

}
