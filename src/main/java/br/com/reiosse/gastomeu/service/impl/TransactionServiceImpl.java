package br.com.reiosse.gastomeu.service.impl;

import br.com.reiosse.gastomeu.model.Transaction;
import br.com.reiosse.gastomeu.repository.TransactionRepository;
import br.com.reiosse.gastomeu.service.TransactionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;

    @Override
    public List<Transaction> saveTransaction(Transaction transaction) {
        if(transaction.getIsCreditCardTransaction()){
            return saveCreditCardTransaction(transaction);
        }
        return List.of(transactionRepository.save(transaction));
    }

    @Override
    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    @Override
    public List<Transaction> getCreditCardTransactions() {
        return transactionRepository.findByIsCreditCardTransactionTrue();
    }

    @Override
    public List<Transaction> getNonCreditCardTransactions() {
        return transactionRepository.findByIsCreditCardTransactionFalse();
    }

    @Override
    public Transaction getTransactionById(Long id) {
        return transactionRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteTransactionById(Long id) {
        transactionRepository.deleteById(id);
    }


    private List<Transaction> saveCreditCardTransaction(Transaction transaction) {
        List<Transaction> transactions = new ArrayList<>();
        var originalTransaction = transactionRepository.save(transaction);
        transactions.add(originalTransaction);
        if (transaction.getInstallments() > 1) {
            for (int i = 1; i <= transaction.getInstallments(); i++) {
                Transaction installmentTransaction = Transaction.builder()
                        .category(transaction.getCategory())
                        .creditCard(transaction.getCreditCard())
                        .totalValue(transaction.getTotalValue())
                        .transactionDate(transaction.getTransactionDate())
                        .description(transaction.getDescription())
                        .title(transaction.getTitle())
                        .isCreditCardTransaction(true)
                        .installments(i)
                        .installmentValue(transaction.getTotalValue().divide(BigDecimal.valueOf(transaction.getInstallments()), 2, RoundingMode.HALF_UP))
                        .isRecurring(true)
                        .originalTransactionId(originalTransaction.getId())
                        .build();

                if (i == 1) {
                    installmentTransaction.setBillingDate(transaction.getBillingDate());
                } else {
                    installmentTransaction.setBillingDate(transactions.get(i - 1).getBillingDate().plusDays(30));
                }
                transactions.add(transactionRepository.save(installmentTransaction));
            }
        }
        return transactions;
    }
}
