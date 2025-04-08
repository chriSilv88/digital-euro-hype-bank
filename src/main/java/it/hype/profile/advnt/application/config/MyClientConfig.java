package it.hype.profile.vantaggi.application.config;

import feign.RequestInterceptor;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MyClientConfig {

    private static final String HEADER_NAME = "Random";

    @Value("${my.random}")
    private String random;

    @Bean
    public RequestInterceptor requestInterceptor() {
        return requestTemplate -> {
            requestTemplate.header(
                    HttpHeaders.CONTENT_TYPE,
                    MediaType.APPLICATION_JSON_VALUE);
            requestTemplate.header(
                    HttpHeaders.ACCEPT,
                    MediaType.APPLICATION_JSON_VALUE);
            requestTemplate.header(HEADER_NAME, random);
        };
    }
}
