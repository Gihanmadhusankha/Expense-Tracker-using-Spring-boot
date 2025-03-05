package com.projects.Expense.Tracker.services.income;

import com.projects.Expense.Tracker.dto.IncomeDTO;
import com.projects.Expense.Tracker.entity.Income;
import com.projects.Expense.Tracker.repository.IncomeRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class IncomeServiceIMPL  implements IncomeService{
    @Autowired
    private IncomeRepository incomeRepository;

    public Income  postIncome(IncomeDTO incomeDTO){
        return  saveOrUpdateIncome(new Income(),incomeDTO);
    }
    private Income saveOrUpdateIncome(Income income, IncomeDTO incomeDTO){
        income.setTitle(incomeDTO.getTitle());
        income.setDate(incomeDTO.getDate());
        income.setCategory(incomeDTO.getCategory());
        income.setDescription(incomeDTO.getDescription());

        return incomeRepository.save(income);
    }
    public List<IncomeDTO> getAllIncome(){
        return incomeRepository.findAll().stream()
                .sorted(Comparator.comparing(Income::getDate).reversed())
                .map(Income::getIncomeDto)
                .collect(Collectors.toList());
    }
    public Income updateIncome(Long id, IncomeDTO incomeDTO){
        Optional<Income> optionalExpense=incomeRepository.findById(id);
        if(optionalExpense.isPresent()){
            return saveOrUpdateIncome(optionalExpense.get(),incomeDTO);
        }else{
            throw new EntityNotFoundException("Expense is not present with id"+id);
        }
    }
    public IncomeDTO getIncomeById(Long id) {
        Optional<Income> optionalIncome = incomeRepository.findById(id);
        if (optionalIncome.isPresent()) {
            return optionalIncome.get().getIncomeDto();
        } else {
            throw new EntityNotFoundException("Income is not present with id" + id);
        }

    }
    public void deleteIncome(Long id){
        Optional<Income> optionalExpense =incomeRepository.findById(id);
        if(optionalExpense.isPresent()){
            incomeRepository.deleteById(id);
        }
        else{
            throw new EntityNotFoundException("Income is no present with id"+id);
        }
    }


}
