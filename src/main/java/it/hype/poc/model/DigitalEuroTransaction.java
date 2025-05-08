package it.hype.poc.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document(collection = "digitaleurotransaction")
public class DigitalEuroTransaction {
    @Id
    private String id;
    private String name;
    private LocalDateTime createdAt = LocalDateTime.now();
}
