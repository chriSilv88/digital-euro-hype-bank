package it.hype.profile.pocdigitaleuro.domain.repository;

import it.hype.profile.pocdigitaleuro.domain.models.mongo.MyDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMyRepository extends MongoRepository<MyDocument, String> {


}
