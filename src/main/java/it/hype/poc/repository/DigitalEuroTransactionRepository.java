package it.hype.poc.repository;

import it.hype.poc.model.DigitalEuroTransaction;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DigitalEuroTransactionRepository extends MongoRepository<DigitalEuroTransaction, String> {
}
