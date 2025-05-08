package it.hype.poc;

import it.hype.poc.model.DigitalEuroTransaction;
import it.hype.poc.repository.DigitalEuroTransactionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MongoTestRunner implements CommandLineRunner {

    private final DigitalEuroTransactionRepository repository;

    public MongoTestRunner(DigitalEuroTransactionRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... args) {
        DigitalEuroTransaction doc = new DigitalEuroTransaction();
        doc.setName("Test Document");

        repository.save(doc);

        System.out.println("Documents in DB: " + repository.count());
        repository.findAll().forEach(d -> System.out.println(" - " + d.getName()));
    }
}
