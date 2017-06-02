package com.imobiliare.controllers;

import static org.junit.Assert.*;

import java.util.List;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.imobiliare.ImobiliareApplication;
import com.imobiliare.DTOs.UserDTO;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ImobiliareApplication.class)
@Transactional
public class UserControllerTest {
	@Autowired
	UserController userController;

	@Test
	public void whenRequestGetAllShouldReturnOkAndUserDTOList() {
		UserDTO userDto = new UserDTO.UserDTOBuilder().email("email1@").firstName("testUser").lastName("testUser")
				.phoneNumber("phone").create();
		userController.save(userDto);
		ResponseEntity<List<UserDTO>> response = userController.getAll();
		assertTrue(response != null);
	}

	@SuppressWarnings("rawtypes")
	@Test
	public void saveUserThenExpectHttpStatusToBeCreated() {
		UserDTO userDto = new UserDTO.UserDTOBuilder().email("email1@").firstName("testUser").lastName("testUser")
				.phoneNumber("phone").create();
		ResponseEntity responseEntity = userController.save(userDto);
		ResponseEntity acResponseEntity = new ResponseEntity(HttpStatus.CREATED);
		assertEquals(responseEntity, acResponseEntity);
	}
}
