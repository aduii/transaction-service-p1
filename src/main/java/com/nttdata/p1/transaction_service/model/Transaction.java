package com.nttdata.p1.transaction_service.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document(collection = "transactions")
public class Transaction {
    @Id
    private String id;
    private String accountId;
    private Double amount;
    private String type; // "DEPOSIT", "WITHDRAWAL", "TRANSFER"
    private String destinationAccountId; // For transfers
    private LocalDateTime date;
    private String status; // "SUCCESS", "FAILED"
}
