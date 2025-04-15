package it.hype.profile.vantaggi.application.service;

import it.hype.profile.vantaggi.domain.repository.IMyRepository;
import it.hype.profile.vantaggi.domain.service.IService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class ServiceImpl implements IService {

    private final IMyRepository repository;

    @Override
    public Object get() {
        return repository.findAll();
    }
}
