package com.barnabas.finance_tracker;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// repository handles the Expense class we just built + primary key = Long
// By extending JpaRepository, instantly gain methods like save, findAll, findById, deleteById..
@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {

}
