package com.barnabas.finance_tracker;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor // automatically generates a constructor for all final fields
public class ExpenseService {
    // provided via Dependency Injection (DI)
    private final ExpenseRepository expenseRepository;

    public List<Expense> getAll() {
        return expenseRepository.findAll();
    }

    public Expense save(Expense expense) {
        return expenseRepository.save(expense);
    }

    public void delete(Long id) {
        if (!expenseRepository.existsById(id)) {
            throw new ResourceNotFoundException("Expense not found with id: " + id);
        }

        expenseRepository.deleteById(id);
    }
}
