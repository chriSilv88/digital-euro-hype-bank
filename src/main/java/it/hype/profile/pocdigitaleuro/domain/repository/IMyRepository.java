package it.hype.profile.pocdigitaleuro.domain.repository;

import it.hype.profile.pocdigitaleuro.domain.models.mongo.MyDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

/**
 * Repository per la gestione dei documenti MyDocument salvati su MongoDB.
 * Espone metodi standard CRUD ed estensioni per le query comunemente utilizzate.
 */
@Repository
public interface IMyRepository extends MongoRepository<MyDocument, String> {

    /**
     * Recupera tutti i documenti attivi (non cancellati logicamente).
     *
     * @return lista di documenti attivi
     */
    List<MyDocument> findByDeletedFalse();

    /**
     * Recupera tutti i documenti creati da uno specifico utente.
     *
     * @param userId ID dell'utente
     * @return lista di documenti dell'utente
     */
    List<MyDocument> findByUserIdAndDeletedFalse(String userId);

    /**
     * Cerca un documento specifico attivo.
     *
     * @param id ID del documento
     * @return documento se presente e non cancellato
     */
    Optional<MyDocument> findByIdAndDeletedFalse(String id);

    /**
     * Verifica se esiste almeno un documento con un determinato stato.
     *
     * @param status stato da cercare
     * @return true se presente almeno un documento con quel stato
     */
    boolean existsByStatusAndDeletedFalse(String status);

    /**
     * Recupera tutti i documenti creati dopo un certo timestamp.
     *
     * @param fromData data di inizio (inclusiva)
     * @return lista ordinata per data decrescente
     */
    List<MyDocument> findByCreatedAtAfterAndDeletedFalseOrderByCreatedAtDesc(Instant fromData);

    /**
     * Recupera tutti i documenti per stato specifico (es. PENDING, COMPLETED).
     *
     * @param status stato logico del documento
     * @return lista filtrata per stato
     */
    List<MyDocument> findByStatusAndDeletedFalse(String status);

    /**
     * Recupera i documenti creati tra due date.
     *
     * @param start inizio intervallo (incluso)
     * @param end fine intervallo (incluso)
     * @return lista documenti
     */
    List<MyDocument> findByCreatedAtBetweenAndDeletedFalse(Instant start, Instant end);
}
