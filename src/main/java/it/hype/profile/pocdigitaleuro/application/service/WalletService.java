package it.hype.poc.service;

import it.hype.poc.model.Wallet;
import it.hype.poc.repository.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class WalletService {
    @Autowired
    private WalletRepository walletRepository;

    public Wallet getWalletById(String id) {
        return walletRepository.findById(id).orElse(null);
    }

    public Wallet saveWallet(Wallet wallet) {
        return walletRepository.save(wallet);
    }
}