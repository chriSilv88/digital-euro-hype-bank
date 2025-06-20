package it.hype.profile.pocdigitaleuro.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.context.annotation.Configuration;

/**
 * Configurazione OpenAPI per il progetto Digital Euro.
 * Espone i metadati dell'API e abilita la sicurezza tramite JWT Bearer Token.
 */
@OpenAPIDefinition(
    info = @Info(
        title = "Digital Euro API",
        version = "v1.2.3",
        description = "API ufficiale per l'integrazione con il sistema Digital Euro.\n\n" +
                      "Questa documentazione descrive i servizi REST disponibili per gestire:\n" +
                      "- Transazioni digitali con diritto di ripensamento\n" +
                      "- Wallet balance e cronologia movimenti\n" +
                      "- Autorizzazioni e cancellazioni dei pagamenti\n\n" +
                      "**Nota:** l'accesso richiede autenticazione via JWT Bearer Token.",
        contact = @Contact(
            name = "Team Backend Digital Euro",
            email = "digital-euro-support@hype-group.example",
            url = "https://intranet.hype-group.example/projects/digital-euro"
        ),
        license = @License(
            name = "Proprietary License",
            url = "https://intranet.hype-group.example/licenses/digital-euro"
        )
    ),
    servers = {
        @Server(
            url = "https://api-stage.hype-group.example/digital-euro",
            description = "Staging Environment"
        ),
        @Server(
            url = "https://api.hype-group.example/digital-euro",
            description = "Production Environment"
        )
    },
    security = {
        @SecurityRequirement(name = "bearerAuth")
    }
)
@SecurityScheme(
    name = "bearerAuth",
    type = SecuritySchemeType.HTTP,
    bearerFormat = "JWT",
    scheme = "bearer",
    description = "Autenticazione tramite JWT Bearer Token. Esempio: `Authorization: Bearer eyJhbGciOi...`"
)
@Configuration
public class OpenApiConfig {
  
}
