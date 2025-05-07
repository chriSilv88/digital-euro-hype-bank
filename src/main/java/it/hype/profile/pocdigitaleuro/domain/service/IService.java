package it.hype.profile.pocdigitaleuro.domain.service;

import it.hype.profile.pocdigitaleuro.domain.models.mongo.MyDocument;
import java.util.List;

public interface IService {
    List<MyDocument> findAll();
    MyDocument save(MyDocument doc);
}
