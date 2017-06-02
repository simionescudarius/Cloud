package com.imobiliare.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.imobiliare.models.RealEstateType;

@Repository
public interface RealEstateTypeRepository extends JpaRepository<RealEstateType, Long>{
}
