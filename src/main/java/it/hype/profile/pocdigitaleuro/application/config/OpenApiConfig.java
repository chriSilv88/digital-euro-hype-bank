package it.hype.profile.pocdigitaleuro.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(
    info = @Info(title = "Digital Euro API", version = "v1"),
    servers = @Server(url = "/TODO")
)
@Configuration
public class OpenApiConfig {}
