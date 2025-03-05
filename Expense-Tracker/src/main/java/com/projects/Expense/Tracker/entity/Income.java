package com.projects.Expense.Tracker.entity;

import com.projects.Expense.Tracker.dto.IncomeDTO;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
@Entity
@Table(name="income")
@Data
public class Income {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private String category;
    private LocalDate date;
    private Integer amount;


    public IncomeDTO getIncomeDto(){
        IncomeDTO incomeDTO=new IncomeDTO();
        incomeDTO.setId(id);
        incomeDTO.setTitle(title);
        incomeDTO.setDescription(description);
        incomeDTO.setCategory(category);
        incomeDTO.setAmount(amount);

        return incomeDTO;
    }
}
