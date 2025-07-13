package com.kd.SystemDesign.LLD.Questions.Library.Entity;

import org.springframework.transaction.TransactionStatus;

import java.util.Date;

public class BookTransaction {
    private String transactionId;
    private String bookIsbn;
    private String userId;
    private Date transactionDate;
    private Date dueDate;
    private Date returnDate;
    private double fineAmount;
    private TransactionStatus status;
    private String notes;
}
