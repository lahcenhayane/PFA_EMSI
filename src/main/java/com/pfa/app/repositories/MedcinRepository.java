package com.pfa.app.repositories;

import com.pfa.app.Entities.MedcinEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedcinRepository extends MongoRepository<MedcinEntity, String> {
}
