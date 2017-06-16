package com.imobiliare.services;

import static org.junit.Assert.*;

import javax.transaction.Transactional;
import javax.ws.rs.NotAuthorizedException;

import org.apache.http.auth.InvalidCredentialsException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.imobiliare.ImobiliareApplication;
import com.imobiliare.DTOs.UserDTO;
import com.imobiliare.models.User;
import com.imobiliare.transformers.UserTransformer;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ImobiliareApplication.class)
@Transactional
public class UserServiceTest {

	@Autowired
	UserService userService;

	UserTransformer userTransformer;
	User user;
	UserDTO userDto;

	@Before
	public void setUp() throws Exception {
		userTransformer = new UserTransformer();
		userDto = new UserDTO.UserDTOBuilder().announcements(null).email("testUser@gmail.com")
				.firstName("firstName").lastName("lastName").meetings(null).phoneNumber("0744640690").create();
		user = userTransformer.toModel(userDto);
		userService.save(user);
	}

	@Test
	public void addAUserAndShouldReturnSameUser() {
		user = userService.getByEmail("testUser@gmail.com");
		assertTrue(user.getEmail().equals(userDto.getEmail()));
	}

	@Test
	public void takeUserByEmailShouldBeSameWithUserInSetUp() {
		User user2 = userService.getByEmail(user.getEmail());
		assertTrue(user.getId() == user2.getId());
	}
	
	@Test
	public void validateLoginWithCorrectDataAndShouldReturnTrue(){
		boolean success = true;
		try{
		userService.validateCredentials("testUser@gmail.com", "parola");
		}catch(NotAuthorizedException | InvalidCredentialsException exception){
			success = false;
		}
		assertTrue(success);
	}
	
	@Test
	public void validateLoginWithIncorrectDataAndShouldReturnTrue(){
		boolean success = true;
		try{
		userService.validateCredentials("incorrect@gmail.com", "parola");
		}catch(InvalidCredentialsException exception){
			success = false;
		}
		assertFalse(success);
	}
}
