package it.hype.profile.pocdigitaleuro.application;

import it.hype.profile.pocdigitaleuro.domain.service.IService;
import it.hype.profile.pocdigitaleuro.domain.models.mongo.MyDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/documents")
public class Controller {

    private final IService service;

    @Autowired
    public Controller(IService service) {
        this.service = service;
    }

    @GetMapping
    public List<MyDocument> getAll() {
        return service.findAll();
    }

    @PostMapping
    public MyDocument save(@RequestBody MyDocument doc) {
        return service.save(doc);
    }
}
