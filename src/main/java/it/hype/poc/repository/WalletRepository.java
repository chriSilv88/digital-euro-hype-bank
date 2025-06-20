package it.hype.poc.repository;

import it.hype.poc.model.Wallet;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository per l'entità Wallet.
 * Fornisce l'accesso ai dati dei wallet degli utenti, utilizzati per i pagamenti in Euro Digitale.
 * Parte integrante del Wallet Balance Service per il recupero e la visualizzazione del saldo.
 */
@Repository
public interface WalletRepository extends MongoRepository<Wallet, String> {

    /**
     * Recupera un wallet tramite il walletId (DEAN).
     *
     * @param walletId identificativo del wallet (DEAN)
     * @return Wallet corrispondente, se presente
     */
    Wallet findByWalletId(String walletId);
}
