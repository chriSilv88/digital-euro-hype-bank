package it.hype.profile.vantaggi.infrastructure.repository;

import it.hype.profile.vantaggi.domain.models.MyDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IMyMongoRepository extends MongoRepository<MyDocument, String> {
}
