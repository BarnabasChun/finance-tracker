package com.barnabas.finance_tracker;


import com.barnabas.finance_tracker.dto.ExpenseCreateRequest;
import com.barnabas.finance_tracker.dto.ExpenseDTO;
import com.barnabas.finance_tracker.mapper.ExpenseMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class ExpenseServiceTest {
    @Mock
    private ExpenseMapper expenseMapper;

    @Mock
    private ExpenseRepository expenseRepository;

    @InjectMocks
    private ExpenseService expenseService;

    @Test
    public void should_ReturnDtoWithId_When_ExpenseIsCreated() {
        ExpenseCreateRequest expenseCreateRequest = ExpenseCreateRequest.builder()
            .amount(new BigDecimal("2.86"))
            .category("Food")
            .description("Coffee")
            .build();

        Expense entityToSave = Expense.builder()
                .amount(new BigDecimal("2.86"))
                .category("Food")
                .description("Coffee")
                .build();

        Expense savedEntityWithId = Expense.builder()
                .amount(new BigDecimal("2.86"))
                .category("Food")
                .description("Coffee")
                .id(1L)
                .build();

        ExpenseDTO expectedResponse = ExpenseDTO.builder()
                .amount(new BigDecimal("2.86"))
                .category("Food")
                .description("Coffee")
                .id(1L)
                .build();

        given(expenseMapper.toEntity(expenseCreateRequest)).willReturn(entityToSave);
        given(expenseRepository.save(entityToSave)).willReturn(savedEntityWithId);
        given(expenseMapper.toDTO(savedEntityWithId)).willReturn(expectedResponse);

        ExpenseDTO resultingResponse = expenseService.save(expenseCreateRequest);

        assertThat(resultingResponse).isEqualTo(expectedResponse);
        verify(expenseRepository).save(any(Expense.class)); // verifies mock for `save` was called properly
    }
}
