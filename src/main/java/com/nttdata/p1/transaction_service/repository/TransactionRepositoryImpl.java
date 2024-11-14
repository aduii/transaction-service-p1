package com.nttdata.p1.transaction_service.repository;

import com.nttdata.p1.transaction_service.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public class TransactionRepositoryImpl implements TransactionRepository {

    @Autowired
    private CRUDRepository crudRepository;

    @Override
    public Mono<Transaction> createTransaction(Transaction transaction) {
        return crudRepository.save(transaction);
    }

    @Override
    public Flux<Transaction> getAllTransactions() {
        return crudRepository.findAll();
    }

    @Override
    public Mono<Transaction> findByTransactionId(String id) {
        return crudRepository.findById(id);
    }

    @Override
    public Flux<Transaction> getTransactionsByAccountId(String accountId) {
        return crudRepository.findByAccountId(accountId);
    }

    @Override
    public Mono<Transaction> updateTransaction(String id, Transaction transaction) {
        return crudRepository.findById(id)
                .flatMap(existingTransaction -> {
                    existingTransaction.setAmount(transaction.getAmount());
                    existingTransaction.setType(transaction.getType());
                    existingTransaction.setDestinationAccountId(transaction.getDestinationAccountId());
                    existingTransaction.setStatus(transaction.getStatus());
                    return crudRepository.save(existingTransaction);
                });
    }

    @Override
    public Mono<Void> deleteTransaction(String id) {
        return crudRepository.deleteById(id);
    }
}
