package com.barnabas.finance_tracker;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// repository interacts with the DB
// By extending JpaRepository, instantly gain methods like save, findAll, findById, deleteById..
@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {

}
