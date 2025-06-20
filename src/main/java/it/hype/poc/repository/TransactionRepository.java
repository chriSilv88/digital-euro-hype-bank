package it.hype.poc.repository;

import it.hype.poc.model.Transaction;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * Repository per l'entità Transaction.
 * Fornisce l'accesso al database MongoDB per le transazioni generiche gestite dal sistema.
 * Utilizzato nei servizi di visualizzazione della cronologia e gestione dei pagamenti.
 */
@Repository
public interface TransactionRepository extends MongoRepository<Transaction, String> {

    /**
     * Trova tutte le transazioni associate a un wallet.
     *
     * @param walletId Identificativo del wallet
     * @return lista di transazioni
     */
    List<Transaction> findByWalletId(String walletId);

    /**
     * Trova transazioni per walletId e stato.
     *
     * @param walletId identificativo del wallet
     * @param status stato della transazione
     * @return lista di transazioni filtrate
     */
    List<Transaction> findByWalletIdAndStatus(String walletId, String status);

    /**
     * Trova transazioni entro un intervallo di date.
     *
     * @param walletId identificativo del wallet
     * @param from data inizio (inclusiva)
     * @param to data fine (inclusiva)
     * @return lista filtrata per data
     */
    List<Transaction> findByWalletIdAndCreatedDateBetween(String walletId, Date from, Date to);
}
