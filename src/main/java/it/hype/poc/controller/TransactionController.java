package it.hype.poc.controller;

import it.hype.poc.model.Transaction;
import it.hype.poc.model.TransactionStatus;
import it.hype.poc.model.TransactionType;

import it.hype.poc.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {
    @Autowired
    private TransactionService transactionService;

    @GetMapping
    public ResponseEntity<List<Transaction>> getAllTransactions(
        @RequestParam(name = "walletId") String walletId,
        @RequestParam(name = "status", required = false) TransactionStatus status,
        @RequestParam(name = "type", required = false) TransactionType type,
        @RequestParam(name = "rightOfWithdrawal", required = false) Boolean hasRightOfWithdrawal,
        @RequestParam(name = "fromDate", required = false) String fromDate,
        @RequestParam(name = "toDate", required = false) String toDate,
        @RequestParam(name = "limit", required = false, defaultValue = "50") int limit,
        @RequestParam(name = "offset", required = false, defaultValue = "0") int offset
){
        List<Transaction> results = transactionService.getFilteredTransactions(
            walletId, status, type, hasRightOfWithdrawal, fromDate, toDate, limit, offset
        );
        return ResponseEntity.ok(results);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Transaction> getTransactionById(@PathVariable String id) {
        Transaction tx = transactionService.getTransactionById(id);
        if (tx != null) {
            return ResponseEntity.ok(tx);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Transaction> createTransaction(@RequestBody Transaction tx) {
        return ResponseEntity.ok(transactionService.saveTransaction(tx));
    }
}
