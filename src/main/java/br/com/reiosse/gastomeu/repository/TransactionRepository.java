package br.com.reiosse.gastomeu.repository;

import br.com.reiosse.gastomeu.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findByIsCreditCardTransactionTrue();
    List<Transaction> findByIsCreditCardTransactionFalse();
}
