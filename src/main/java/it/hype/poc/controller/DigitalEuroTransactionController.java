package it.hype.poc.controller;

import it.hype.poc.model.DigitalEuroTransaction;
import it.hype.poc.repository.DigitalEuroTransactionRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transactions")
public class DigitalEuroTransactionController {

    private final DigitalEuroTransactionRepository repository;

    public DigitalEuroTransactionController(DigitalEuroTransactionRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public DigitalEuroTransaction create(@RequestBody DigitalEuroTransaction tx) {
        return repository.save(tx);
    }

    @GetMapping
    public List<DigitalEuroTransaction> getAll() {
        return repository.findAll();
    }
}
