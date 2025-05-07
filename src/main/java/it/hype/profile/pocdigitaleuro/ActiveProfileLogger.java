package it.hype.profile.pocdigitaleuro;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ActiveProfileLogger implements CommandLineRunner {

    @Value("${spring.profiles.active}")
    private String activeProfile;

    @Override
    public void run(String... args) {
        System.out.println("✅ Spring Boot active profile: " + activeProfile);
    }
}
