package com.nttdata.p1.transaction_service.service;

import com.nttdata.p1.transaction_service.model.Transaction;
import com.nttdata.p1.transaction_service.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class TransactionServiceImpl implements TransactionService{

    @Autowired
    private TransactionRepository transactionRepository;

    @Override
    public Mono<Transaction> createTransaction(Transaction transaction) {
        return transactionRepository.createTransaction(transaction);
    }

    @Override
    public Flux<Transaction> getAllTransactions() {
        return transactionRepository.getAllTransactions();
    }

    @Override
    public Mono<Transaction> findByTransactionId(String id) {
        return transactionRepository.findByTransactionId(id);
    }

    @Override
    public Flux<Transaction> getTransactionsByAccountId(String accountId) {
        return transactionRepository.getTransactionsByAccountId(accountId);
    }

    @Override
    public Mono<Transaction> updateTransaction(String id, Transaction transaction) {
        return transactionRepository.updateTransaction(id, transaction);
    }

    @Override
    public Mono<Void> deleteTransaction(String id) {
        return transactionRepository.deleteTransaction(id);
    }
}
