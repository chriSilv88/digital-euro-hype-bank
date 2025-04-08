package it.hype.profile.vantaggi.infrastructure.repository;

import it.hype.profile.vantaggi.domain.models.MyDocument;
import it.hype.profile.vantaggi.domain.repository.IMyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MyRepositoryImpl implements IMyRepository {

    private final IMyMongoRepository repository;

    @Autowired
    public MyRepositoryImpl(IMyMongoRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<MyDocument> findAll() {
        return repository.findAll();
    }
}
