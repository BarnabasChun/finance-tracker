package com.barnabas.finance_tracker;

import com.barnabas.finance_tracker.dto.ExpenseCreateRequest;
import com.barnabas.finance_tracker.dto.ExpenseDTO;
import com.barnabas.finance_tracker.mapper.ExpenseMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor // automatically generates a constructor for all final fields
public class ExpenseService {
    // provided via Dependency Injection (DI)
    private final ExpenseRepository expenseRepository;
    private final ExpenseMapper expenseMapper;

    public List<ExpenseDTO> getAll() {
        return expenseRepository
                .findAll()
                .stream() // convert static list to a format which allows for sequential processing
                .map(expenseMapper::toDTO) // shorthand for: `map(expense -> expenseMapper.toDTO(expense))`
                .collect(Collectors.toList()); // terminal operation to acc. result into the required structure, in this case a List
    }

    public ExpenseDTO save(ExpenseCreateRequest request) {
        Expense expense = expenseMapper.toEntity(request);
        Expense saved = expenseRepository.save(expense);

        return expenseMapper.toDTO(saved);
    }

    public void delete(Long id) {
        if (!expenseRepository.existsById(id)) {
            throw new ResourceNotFoundException("Expense not found with id: " + id);
        }

        expenseRepository.deleteById(id);
    }
}
