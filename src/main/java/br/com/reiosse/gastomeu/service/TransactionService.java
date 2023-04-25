package br.com.reiosse.gastomeu.service;

import br.com.reiosse.gastomeu.model.Transaction;

import java.util.List;

public interface TransactionService {
    List<Transaction> saveTransaction(Transaction transaction);
    List<Transaction> getAllTransactions();

    List<Transaction> getCreditCardTransactions();

    List<Transaction> getNonCreditCardTransactions();

    Transaction getTransactionById(Long id);
    void deleteTransactionById(Long id);
}
