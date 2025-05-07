package it.hype.profile.pocdigitaleuro.application.service;

import it.hype.profile.pocdigitaleuro.domain.service.IService;
import it.hype.profile.pocdigitaleuro.domain.models.mongo.MyDocument;
import it.hype.profile.pocdigitaleuro.domain.repository.IMyRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceImpl implements IService {

    private final IMyRepository repository;

    public ServiceImpl(IMyRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<MyDocument> findAll() {
        return repository.findAll();
    }

    @Override
    public MyDocument save(MyDocument doc) {
        return repository.save(doc);
    }
}
