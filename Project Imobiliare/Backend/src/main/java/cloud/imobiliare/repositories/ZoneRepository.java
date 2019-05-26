package cloud.imobiliare.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cloud.imobiliare.entities.Zone;

@Repository
public interface ZoneRepository extends JpaRepository<Zone, Long>{
}
