package com.pfa.app.repositories;

import com.pfa.app.Entities.SecretaireEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SecretaireRepository extends JpaRepository<SecretaireEntity, Long> {
}
