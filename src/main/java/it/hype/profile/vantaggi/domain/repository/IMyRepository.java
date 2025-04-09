package it.hype.profile.vantaggi.domain.repository;

import it.hype.profile.vantaggi.domain.models.mongo.MyDocument;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface IMyRepository extends MongoRepository<MyDocument, ObjectId> {

    List<MyDocument> findAll();

}
