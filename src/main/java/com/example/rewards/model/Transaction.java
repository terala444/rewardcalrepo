package com.example.rewards.model;

import lombok.Data;
import java.time.LocalDate;

@Data
public class Transaction {
    private Long customerId;
    private double amount;
    private LocalDate date;
}