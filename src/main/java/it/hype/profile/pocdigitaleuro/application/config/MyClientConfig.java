package it.hype.profile.vantaggi.application.config;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import java.util.Collections;
import java.util.Map;


@Slf4j
@Configuration
public class MyClientConfig {

    @Bean
    @ConfigurationProperties(prefix = "my.client")
    public MyClientProperties myClientProperties() {
        return new MyClientProperties();
    }

    @Bean
    public RequestInterceptor requestInterceptor(MyClientProperties properties) {
        return new RequestInterceptor() {
            @Override
            public void apply(RequestTemplate requestTemplate) {
                // Content negotiation
                requestTemplate.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
                requestTemplate.header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);

                // Custom headers
                requestTemplate.header("Random", properties.getRandom());

                // Optional: Add static or dynamic headers (e.g., Authorization, Trace ID)
                if (properties.getStaticHeaders() != null) {
                    for (Map.Entry<String, String> entry : properties.getStaticHeaders().entrySet()) {
                        requestTemplate.header(entry.getKey(), entry.getValue());
                    }
                }

                // Logging outgoing request
                log.debug("Feign Request to URL: {}, method: {}, headers: {}",
                        requestTemplate.url(),
                        requestTemplate.method(),
                        requestTemplate.headers()
                );
            }
        };
    }

    /**
     * DTO per leggere le proprietà personalizzate del client Feign dal file di configurazione.
     */
    @Getter
    @Setter
    public static class MyClientProperties {

        /**
         * Valore per header custom "Random"
         */
        private String random;

        /**
         * Header statici da aggiungere a ogni richiesta (opzionale)
         */
        private Map<String, String> staticHeaders = Collections.emptyMap();
    }
}
