package it.hype.profile.pocdigitaleuro.application.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

/**
 * MongoDB configuration class.
 * Enables auditing support and configures a secure AuditorAware bean
 * that resolves the current authenticated user from Spring Security context.
 */
@Configuration
@EnableMongoAuditing(auditorAwareRef = "auditorProvider")
public class MongoConfig {

    /**
     * Provides an implementation of AuditorAware that extracts the username
     * from Spring Security's SecurityContext.
     *
     * @return AuditorAware<String>
     */
    @Bean
    public AuditorAware<String> auditorProvider() {
        return new SecurityAuditorAware();
    }

    /**
     * Implementation of AuditorAware that retrieves the current username
     * from Spring Security context. Falls back to 'anonymous' if not authenticated.
     */
    public static class SecurityAuditorAware implements AuditorAware<String> {

        @Override
        public Optional<String> getCurrentAuditor() {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

            if (authentication == null || !authentication.isAuthenticated() ||
                authentication.getPrincipal().equals("anonymousUser")) {
                return Optional.of("system");
            }

            return Optional.ofNullable(authentication.getName());
        }
    }
}
