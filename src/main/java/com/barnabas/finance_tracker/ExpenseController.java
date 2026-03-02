package com.barnabas.finance_tracker;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// the Entry Point of your application. It’s the only part that "talks" to the outside world (the internet).
@RestController
@RequestMapping("/api/expenses")
@RequiredArgsConstructor // automatically generates a constructor for all final fields
public class ExpenseController {
    // provided via Dependency Injection (DI)
    private final ExpenseService expenseService;

    @GetMapping
    public List<Expense> getAllExpenses() {
        return expenseService.getAll();
    }

    @PostMapping
    public Expense createExpense(@RequestBody Expense expense) {
        return expenseService.save(expense);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteExpense(@PathVariable Long id) {
        expenseService.delete(id); // If this fails, the 404 is sent automatically
        return ResponseEntity.noContent().build(); // Returns the 204 No Content status, which is the industry standard for a successful deletion.
    }
}
