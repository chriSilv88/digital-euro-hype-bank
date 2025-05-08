package it.hype.poc.controller;

import it.hype.poc.model.Wallet;
import it.hype.poc.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/wallets")
public class WalletController {
    @Autowired
    private WalletService walletService;

    @GetMapping("/{id}")
    public ResponseEntity<Wallet> getWallet(@PathVariable String id) {
        Wallet wallet = walletService.getWalletById(id);
        if (wallet != null) {
            return ResponseEntity.ok(wallet);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Wallet> createWallet(@RequestBody Wallet wallet) {
        return ResponseEntity.ok(walletService.saveWallet(wallet));
    }
}