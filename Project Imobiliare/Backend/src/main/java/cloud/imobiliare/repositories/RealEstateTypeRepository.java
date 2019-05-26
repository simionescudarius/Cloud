package cloud.imobiliare.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import cloud.imobiliare.entities.RealEstateType;

@Repository
public interface RealEstateTypeRepository extends JpaRepository<RealEstateType, Long>{
	@Query("select t from RealEstateType t where t.name = :name")
	RealEstateType getByName (@Param("name") String name);
}
