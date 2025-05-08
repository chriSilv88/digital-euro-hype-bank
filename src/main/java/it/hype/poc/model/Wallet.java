package it.hype.poc.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Document(collection = "wallets")
public class Wallet {
    @Id
    private String id;
    private String dean;
    private BigDecimal totalBalance;
    private BigDecimal availableBalance;
    private LocalDateTime lastUpdated;

}