package it.hype.poc.repository;

import it.hype.poc.model.DigitalEuroTransaction;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * Repository per l'entità DigitalEuroTransaction.
 * Gestisce l'accesso al database MongoDB per le transazioni effettuate con Euro Digitale.
 * Viene utilizzato per visualizzare la lista movimenti, con possibilità di filtrare
 * per wallet, stato, tipo e diritto di ripensamento.
 *
 * Rientra nel servizio Transaction History Service, come descritto nell'ATE - POC Hype.
 */
@Repository
public interface DigitalEuroTransactionRepository extends MongoRepository<DigitalEuroTransaction, String> {

    /**
     * Restituisce tutte le transazioni per un dato walletId.
     *
     * @param walletId identificativo del wallet (DEAN)
     * @return lista di transazioni
     */
    List<DigitalEuroTransaction> findByWalletId(String walletId);

    /**
     * Restituisce tutte le transazioni filtrate per wallet, tipo, stato e diritto di ripensamento.
     *
     * @param walletId wallet DEAN
     * @param status stato della transazione (PENDING, COMPLETED, CANCELED)
     * @param type tipo della transazione (RESERVATION, PAYMENT)
     * @param hasRightOfWithdrawal true se soggetta a diritto di ripensamento
     * @return lista filtrata
     */
    List<DigitalEuroTransaction> findByWalletIdAndStatusAndTypeAndRightOfWithdrawal(
            String walletId,
            String status,
            String type,
            boolean hasRightOfWithdrawal
    );

    /**
     * Restituisce tutte le transazioni entro un intervallo temporale.
     *
     * @param walletId wallet DEAN
     * @param from data di inizio (inclusa)
     * @param to data di fine (inclusa)
     * @return lista di transazioni
     */
    List<DigitalEuroTransaction> findByWalletIdAndCreatedDateBetween(
            String walletId,
            Date from,
            Date to
    );
}
