package com.barnabas.finance_tracker;

// Jakarta Persistence (JPA) allows for mapping Java objects to database tables using annotations and entity classes

import jakarta.persistence.*; // if you use more than a certain number of classes from the same package (usually 5), editor automatically collapses them into a wildcard import to keep the top of your file "clean."
import lombok.Data; // eliminated need to manually write Getters, Setters
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
public class Expense {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //    delegates ID assignment to the database using an auto-incremented column
    private Long id;

    private String description;
    private BigDecimal amount;
    private String category;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;
}
