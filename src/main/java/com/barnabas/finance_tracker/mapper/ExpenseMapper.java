package com.barnabas.finance_tracker.mapper;

import com.barnabas.finance_tracker.Expense;
import com.barnabas.finance_tracker.dto.ExpenseCreateRequest;
import com.barnabas.finance_tracker.dto.ExpenseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

// MapStruct generates an implementation class and marked it as a Spring @Component. This means you can "Inject" it anywhere.
@Mapper(componentModel = "Spring")
public interface ExpenseMapper {

    ExpenseDTO toDTO(Expense expense);

    // Request -> Entity
    @Mapping(target = "id", ignore = true)        // Database generates the ID
    @Mapping(target = "createdAt", ignore = true) // Database generates the date
    Expense toEntity(ExpenseCreateRequest request);
}
