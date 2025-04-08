package it.hype.profile.vantaggi.application;

import it.hype.profile.vantaggi.domain.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    private final IService service;

    @Autowired
    public Controller(IService service) {
        this.service = service;
    }

    @GetMapping(value = "/v1")
    public Object get() {
        return service.get();
    }
}
