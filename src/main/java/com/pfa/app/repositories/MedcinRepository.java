package com.pfa.app.repositories;

import com.pfa.app.Entities.MedcinEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedcinRepository extends JpaRepository<MedcinEntity, Long> {
}
