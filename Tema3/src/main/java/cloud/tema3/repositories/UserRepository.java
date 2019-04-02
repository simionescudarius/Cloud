package cloud.tema3.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cloud.tema3.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

}
