package com.imobiliare.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.imobiliare.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	@Modifying
	@Query("update User u set u.firstName = :firstName where u.id = :id")
	void updateFirstName(@Param("id") Long id, @Param("firstName") String firstName);
	
	@Modifying
	@Query("update User u set u.lastName = :lastName where u.id = :id")
	void updateLastName(@Param("id") long id, @Param("lastName") String lastName);
	
	@Modifying
	@Query("update User u set u.email = :email where u.id = :id")
	void updateEmail(@Param("id") long id, @Param("email") String email);
	
	@Modifying
	@Query("update User u set u.phoneNumber = :phoneNumber where u.id = :id")
	void updatePhoneNumber(@Param("id") long id, @Param("phoneNumber") String phoneNumber);
	
	@Query("select u from User u where u.email = :email")
	User findByEmail (@Param("email") String email);
	
	@Query("select u.password from User u where u.email = :email")
	String getPassword (@Param("email") String email);
	
	@Query("select u.role from User u where u.email = :email")
	String getRole (@Param("email") String email);
	
	@Query("select u.id from User u where u.email = :email")
	Long getId (@Param("email") String email);
}
