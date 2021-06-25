package com.pfa.app.repositories;

import com.pfa.app.Entities.SecretaireEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SecretaireRepository extends MongoRepository<SecretaireEntity, String> {
}
