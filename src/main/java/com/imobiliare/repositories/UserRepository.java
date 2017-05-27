package com.imobiliare.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.imobiliare.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
	@Modifying
	@Query("update users set first_name = :firstName where user_id = :id")
	void updateFirstName(@Param("id") long id, @Param("firstName") String firstName);
}
