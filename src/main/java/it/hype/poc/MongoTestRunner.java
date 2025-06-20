package it.hype.poc;

import it.hype.poc.model.DigitalEuroTransaction;
import it.hype.poc.repository.DigitalEuroTransactionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Componente di test per l'inserimento e la lettura di documenti nel database MongoDB.
 * Utilizzato per verificare la corretta configurazione del repository DigitalEuroTransactionRepository.
 */
@Component
public class MongoTestRunner implements CommandLineRunner {

    private final DigitalEuroTransactionRepository repository;

    public MongoTestRunner(DigitalEuroTransactionRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... args) {
        // Crea un documento di test
        DigitalEuroTransaction doc = new DigitalEuroTransaction();
        doc.setName("Test Document");

        // Salva il documento nel database
        repository.save(doc);

        // Output dei risultati
        System.out.println("Documents in DB: " + repository.count());
        repository.findAll().forEach(d ->
            System.out.println(" - " + d.getName())
        );
    }
}
