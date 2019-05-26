package cloud.imobiliare.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cloud.imobiliare.entities.RealEstate;

@Repository
public interface RealEstateRepository extends JpaRepository<RealEstate, Long>{
}
