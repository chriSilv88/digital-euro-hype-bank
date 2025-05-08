package it.hype.profile.pocdigitaleuro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication(exclude = {ErrorMvcAutoConfiguration.class})
@ComponentScan(basePackages = {
    "it.hype.poc",
    "it.hype.profile.pocdigitaleuro",
    "it.hype.profile.vantaggi",
    "it.hype.errorhandler",
    "it.hype.authhandler",
    "it.hype.requestinfoaspect"
})
@EnableMongoAuditing
@EnableMongoRepositories(basePackages = {
    "it.hype.poc.repository",
    "it.hype.profile.pocdigitaleuro.domain.repository"
})
@EnableFeignClients
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
