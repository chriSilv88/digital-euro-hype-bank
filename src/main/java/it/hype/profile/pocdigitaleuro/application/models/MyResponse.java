package it.hype.profile.vantaggi.application.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO di risposta per il client remoto.
 * Contiene il payload restituito dall'API remota.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MyResponse implements Serializable {

    /**
     * Risposta generica (può essere una mappa, lista o DTO specifico).
     */
    private Object payload;
}
