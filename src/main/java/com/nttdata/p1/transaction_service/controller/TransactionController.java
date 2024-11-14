package com.nttdata.p1.transaction_service.controller;

import com.nttdata.p1.transaction_service.model.Transaction;
import com.nttdata.p1.transaction_service.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RefreshScope
@RestController
@RequestMapping("/api/v1/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping
    public Mono<Transaction> createTransaction(@RequestBody Transaction transaction){
        return transactionService.createTransaction(transaction);
    }

    @GetMapping
    public Flux<Transaction> getAllTransactions(){
        return transactionService.getAllTransactions();
    }

    @GetMapping("/{id}")
    public Mono<Transaction> findByTransactionId(@PathVariable String id){
        return transactionService.findByTransactionId(id);
    }

    @GetMapping("/account-id/{accountId}")
    public Flux<Transaction> getTransactionsByAccountId(@PathVariable String accountId){
        return transactionService.getTransactionsByAccountId(accountId);
    }

    @PutMapping("/{id}")
    public Mono<Transaction> updateTransaction(
            @PathVariable String id,
            @RequestBody Transaction transaction){
        return transactionService.updateTransaction(id, transaction);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteTransaction(@PathVariable String id){
        return transactionService.deleteTransaction(id);
    }
}
