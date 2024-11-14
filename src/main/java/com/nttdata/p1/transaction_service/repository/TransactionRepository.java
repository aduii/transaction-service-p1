package com.nttdata.p1.transaction_service.repository;

import com.nttdata.p1.transaction_service.model.Transaction;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface TransactionRepository {
    Mono<Transaction> createTransaction(Transaction transaction);
    Flux<Transaction> getAllTransactions();
    Mono<Transaction> findByTransactionId(String id);
    Flux<Transaction> getTransactionsByAccountId(String accountId);
    Mono<Transaction> updateTransaction(String id, Transaction transaction);
    Mono<Void> deleteTransaction(String id);
}
