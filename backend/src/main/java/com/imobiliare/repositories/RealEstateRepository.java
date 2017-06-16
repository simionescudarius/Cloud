package com.imobiliare.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.imobiliare.models.RealEstate;

@Repository
public interface RealEstateRepository extends JpaRepository<RealEstate, Long>{
}
