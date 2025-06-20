package it.hype.profile.pocdigitaleuro.domain.service;

import it.hype.profile.pocdigitaleuro.domain.models.mongo.MyDocument;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

/**
 * Servizio di dominio per la gestione dei documenti MyDocument.
 * Incapsula la logica di business e le operazioni principali su MongoDB.
 */
public interface IService {

    /**
     * Recupera tutti i documenti attivi (non cancellati logicamente).
     *
     * @return lista dei documenti attivi
     */
    List<MyDocument> findAll();

    /**
     * Salva o aggiorna un documento.
     *
     * @param doc il documento da salvare
     * @return documento persistito
     */
    MyDocument save(MyDocument doc);

    /**
     * Recupera un documento per ID, solo se non cancellato.
     *
     * @param id identificativo del documento
     * @return Optional con il documento, se presente
     */
    Optional<MyDocument> findById(String id);

    /**
     * Recupera tutti i documenti per utente.
     *
     * @param userId identificativo dell’utente
     * @return lista dei documenti
     */
    List<MyDocument> findByUser(String userId);

    /**
     * Recupera i documenti in base a stato logico.
     *
     * @param status stato del documento (es. PENDING, COMPLETED)
     * @return lista dei documenti filtrati
     */
    List<MyDocument> findByStatus(String status);

    /**
     * Elimina logicamente un documento (soft delete).
     *
     * @param id ID del documento da eliminare
     * @return true se l’eliminazione ha avuto successo
     */
    boolean softDelete(String id);

    /**
     * Recupera i documenti creati dopo una certa data.
     *
     * @param from timestamp di inizio
     * @return lista di documenti
     */
    List<MyDocument> findCreatedAfter(Instant from);

    /**
     * Verifica l'esistenza di almeno un documento con stato specifico.
     *
     * @param status stato da verificare
     * @return true se almeno uno esiste
     */
    boolean existsWithStatus(String status);
}
