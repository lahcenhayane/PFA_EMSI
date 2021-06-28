package com.pfa.app.repositories;

import com.pfa.app.Entities.RdvEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RdvRepository extends JpaRepository<RdvEntity, Long> {

}
