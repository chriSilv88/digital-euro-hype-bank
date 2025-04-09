package it.hype.profile.vantaggi.application.service;

import it.hype.profile.vantaggi.domain.repository.IMyRepository;
import it.hype.profile.vantaggi.domain.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ServiceImpl implements IService {


    private final IMyRepository repository;

    @Autowired
    public ServiceImpl(IMyRepository repository) {
        this.repository = repository;
    }

    @Override
    public Object get() {
        return repository.findAll();
    }
}
