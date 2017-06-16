package com.imobiliare.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.imobiliare.models.Zone;

@Repository
public interface ZoneRepository extends JpaRepository<Zone, Long>{
}
