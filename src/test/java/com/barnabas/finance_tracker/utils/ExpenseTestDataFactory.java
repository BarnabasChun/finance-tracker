package com.barnabas.finance_tracker.utils;

import com.barnabas.finance_tracker.Expense;
import com.barnabas.finance_tracker.dto.ExpenseCreateRequest;
import com.barnabas.finance_tracker.dto.ExpenseDTO;

import java.math.BigDecimal;
import java.util.function.Consumer;

public class ExpenseTestDataFactory {
    private static final String DEFAULT_DESC = "Coffee";
    private static final String DEFAULT_CATEGORY = "Food";
    private static final BigDecimal DEFAULT_AMOUNT = new BigDecimal("2.86");
    private static final Long DEFAULT_ID = 1L;

    public static ExpenseCreateRequest createRequest(Consumer<ExpenseCreateRequest.ExpenseCreateRequestBuilder> customizer) {
        var builder = ExpenseCreateRequest.builder()
                .amount(DEFAULT_AMOUNT)
                .category(DEFAULT_CATEGORY)
                .description(DEFAULT_DESC);

        customizer.accept(builder);

        return builder.build();
    }

    public static ExpenseCreateRequest createRequest() {  return createRequest(b -> {});  }

    public static Expense createEntity(Consumer<Expense.ExpenseBuilder> customizer) {
        var builder =  Expense.builder()
                .amount(DEFAULT_AMOUNT)
                .category(DEFAULT_CATEGORY)
                .description(DEFAULT_DESC);

        customizer.accept(builder);

        return builder.build();
    }

    public static Expense createEntity() {  return createEntity(b -> {});  }

    public static Expense createEntityWithId(Consumer<Expense.ExpenseBuilder> customizer) {
        return createEntity(b -> {
            b.id(DEFAULT_ID);
            customizer.accept(b);
        });
    }

    public static Expense createEntityWithId() {  return createEntityWithId(b -> {});  }

    public static ExpenseDTO createResponseDto(Consumer<ExpenseDTO.ExpenseDTOBuilder> customizer) {
        var builder =  ExpenseDTO.builder()
                .amount(DEFAULT_AMOUNT)
                .category(DEFAULT_CATEGORY)
                .description(DEFAULT_DESC)
                .id(DEFAULT_ID);

        customizer.accept(builder);

        return builder.build();
    }

    public static ExpenseDTO createResponseDto() {  return createResponseDto(b -> {});  }
}
