package tema5.azure.cloud.dao;

import org.springframework.stereotype.Repository;

import com.microsoft.azure.spring.data.cosmosdb.repository.DocumentDbRepository;

import tema5.azure.cloud.entities.User;

@Repository
public interface UserRepository extends DocumentDbRepository<User, String> {
}
