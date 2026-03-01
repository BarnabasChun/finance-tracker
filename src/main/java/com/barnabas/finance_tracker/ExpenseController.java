package com.barnabas.finance_tracker;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/expenses")
@RequiredArgsConstructor // automatically generates a constructor for all final fields
public class ExpenseController {
    // provided via Dependency Injection (DI)
    private final ExpenseRepository expenseRepository;

    @GetMapping
    public List<Expense> getAllExpenses() {
        return expenseRepository.findAll();
    }

    @PostMapping
    public Expense createExpense(@RequestBody Expense expense) {
        return expenseRepository.save(expense);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteExpense(@PathVariable Long id) {
        if (!expenseRepository.existsById(id)) {
            return ResponseEntity.notFound().build(); // Returns 404 if it's already gone
        }

        expenseRepository.deleteById(id); // method return is void

        return ResponseEntity.noContent().build(); // Returns the 204 No Content status, which is the industry standard for a successful deletion.
    }
}
