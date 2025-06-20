package it.hype.poc.model;

import it.hype.poc.model.TransactionStatus;
import it.hype.poc.model.TransactionType;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Document(collection = "transactions")
public class Transaction {
    @Id
    private String id;
    private String walletId;
    private TransactionStatus status;
    private TransactionType type;
    private BigDecimal amount;
    private String counterpartyId;
    private String description;
    private boolean rightOfWithdrawal;
    private LocalDateTime rightOfWithdrawalExpiryDate;
    private LocalDateTime createdDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getWalletId() {
        return walletId;
    }

    public void setWalletId(String walletId) {
        this.walletId = walletId;
    }

    public TransactionType getType() {
        return type;
    }

    public void setType(TransactionType type) {
        this.type = type;
    }

    public TransactionStatus getStatus() {
        return status;
    }

    public void setStatus(TransactionStatus status) {
        this.status = status;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getCounterpartyId() {
        return counterpartyId;
    }

    public void setCounterpartyId(String counterpartyId) {
        this.counterpartyId = counterpartyId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isRightOfWithdrawal() {
        return rightOfWithdrawal;
    }

    public void setRightOfWithdrawal(boolean rightOfWithdrawal) {
        this.rightOfWithdrawal = rightOfWithdrawal;
    }

    public LocalDateTime getRightOfWithdrawalExpiryDate() {
        return rightOfWithdrawalExpiryDate;
    }

    public void setRightOfWithdrawalExpiryDate(LocalDateTime rightOfWithdrawalExpiryDate) {
        this.rightOfWithdrawalExpiryDate = rightOfWithdrawalExpiryDate;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }
}

