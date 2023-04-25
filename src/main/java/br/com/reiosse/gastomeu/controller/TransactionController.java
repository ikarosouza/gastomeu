package br.com.reiosse.gastomeu.controller;

import br.com.reiosse.gastomeu.model.Transaction;
import br.com.reiosse.gastomeu.service.TransactionService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transactions")
@AllArgsConstructor
public class TransactionController {

    private final TransactionService transactionService;

    @GetMapping
    public ResponseEntity<List<Transaction>> getAllTransactions() {
        List<Transaction> transactions = transactionService.getAllTransactions();
        return ResponseEntity.ok(transactions);
    }

    @GetMapping("/credit")
    public ResponseEntity<List<Transaction>> getCreditCardTransactions() {
        List<Transaction> transactions = transactionService.getCreditCardTransactions();
        return ResponseEntity.ok(transactions);
    }

    @GetMapping("/noncredit")
    public ResponseEntity<List<Transaction>> getNonCreditCardTransactions() {
        List<Transaction> transactions = transactionService.getNonCreditCardTransactions();
        return ResponseEntity.ok(transactions);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Transaction> getTransactionById(@PathVariable Long id) {
        Transaction transaction = transactionService.getTransactionById(id);
        if (transaction == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(transaction);
    }

    @PostMapping
    public ResponseEntity<Transaction> saveTransaction(@RequestBody Transaction transaction) {
        Transaction savedTransaction = transactionService.saveTransaction(transaction);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedTransaction);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTransactionById(@PathVariable Long id) {
        transactionService.deleteTransactionById(id);
        return ResponseEntity.noContent().build();
    }
}

