package it.hype.poc.service;

import it.hype.poc.model.Transaction;
import it.hype.poc.model.TransactionStatus;
import it.hype.poc.model.TransactionType;
import it.hype.poc.repository.TransactionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

@Service
public class TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    public Transaction getTransactionById(String id) {
        return transactionRepository.findById(id).orElse(null);
    }

    public Transaction saveTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    public List<Transaction> getFilteredTransactions(
        String walletId,
        TransactionStatus status, 
        TransactionType type, 
        Boolean hasRightOfWithdrawal, 
        String fromDate, 
        String toDate) {
        List<Criteria> criteriaList = new ArrayList<>();

        criteriaList.add(Criteria.where("walletId").is(walletId));

        if (status != null) {
            criteriaList.add(Criteria.where("status").is(status));
        }

        if (type != null) {
            criteriaList.add(Criteria.where("type").is(type));
        }

        if (hasRightOfWithdrawal != null) {
            criteriaList.add(Criteria.where("rightOfWithdrawal").is(hasRightOfWithdrawal));
        }

        if (fromDate != null) {
            try {
                LocalDateTime from = LocalDateTime.parse(fromDate);
                criteriaList.add(Criteria.where("createdDate").gte(from));
            } catch (DateTimeParseException e) {
                System.out.println("Formato data non valido per fromDate: " + fromDate);
            }
        }

        if (toDate != null) {
            try {
                LocalDateTime to = LocalDateTime.parse(toDate);
                criteriaList.add(Criteria.where("createdDate").lte(to));
            } catch (DateTimeParseException e) {
                System.out.println("Formato data non valido per toDate: " + toDate);
            }
        }

        Query query = new Query();
        if (!criteriaList.isEmpty()) {
            query.addCriteria(new Criteria().andOperator(criteriaList.toArray(new Criteria[0])));
        }

        System.out.println("Query generata: " + query);
        return mongoTemplate.find(query, Transaction.class);
    }
}
