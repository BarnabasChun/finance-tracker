package com.barnabas.finance_tracker;


import com.barnabas.finance_tracker.dto.ExpenseDTO;
import com.barnabas.finance_tracker.mapper.ExpenseMapper;
import com.barnabas.finance_tracker.utils.ExpenseTestDataFactory;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

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
        var expenseCreateRequest = ExpenseTestDataFactory.createRequest();
        var entityToSave = ExpenseTestDataFactory.createEntity();
        var savedEntityWithId = ExpenseTestDataFactory.createEntityWithId(b -> b.id(5L));
        var expectedResponse = ExpenseTestDataFactory.createResponseDto(b -> b.id(5L));

        given(expenseMapper.toEntity(expenseCreateRequest)).willReturn(entityToSave);
        given(expenseRepository.save(entityToSave)).willReturn(savedEntityWithId);
        given(expenseMapper.toDTO(savedEntityWithId)).willReturn(expectedResponse);

        ExpenseDTO resultingResponse = expenseService.save(expenseCreateRequest);

        assertThat(resultingResponse).isEqualTo(expectedResponse);
        verify(expenseRepository).save(any(Expense.class)); // verifies mock for `save` was called properly
    }
}
