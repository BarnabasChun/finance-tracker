package com.barnabas.finance_tracker;

import com.barnabas.finance_tracker.dto.ExpenseCreateRequest;
import com.barnabas.finance_tracker.dto.ExpenseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
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
    public List<ExpenseDTO> getAllExpenses() {
        return expenseService.getAll();
    }

    @PostMapping
    public ResponseEntity<ExpenseDTO> createExpense(@RequestBody ExpenseCreateRequest request) {
        return new ResponseEntity<>(expenseService.save(request), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteExpense(@PathVariable Long id) {
        expenseService.delete(id); // If this fails, the 404 is sent automatically
        return ResponseEntity.noContent().build(); // Returns the 204 No Content status, which is the industry standard for a successful deletion.
    }
}
