package com.pfa.app.repositories;

import com.pfa.app.Entities.CompteRenduEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompteRenduRepository extends JpaRepository<CompteRenduEntity, Long> {
}
