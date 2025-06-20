package it.hype.profile.vantaggi.application.client;

import it.hype.profile.vantaggi.application.config.MyClientConfig;
import it.hype.profile.vantaggi.application.models.MyRequest;
import it.hype.profile.vantaggi.application.models.MyResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * Feign client per l'invocazione del servizio remoto configurato tramite {@link MyClientConfig}.
 * Utilizzato per effettuare richieste HTTP POST all'endpoint specificato nella configurazione.
 */
@FeignClient(
    name = "my",
    url = "${my.url}",
    configuration = MyClientConfig.class
)
public interface IMyClient {

    /**
     * Invoca l'endpoint remoto per la ricerca.
     *
     * @param request oggetto contenente i parametri della richiesta
     * @return risposta del servizio remoto
     */
    @PostMapping(
        value = "${my.api.search}",
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    MyResponse search(@RequestBody MyRequest request);
}
