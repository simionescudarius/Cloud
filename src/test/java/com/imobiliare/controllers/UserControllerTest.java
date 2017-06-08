package com.imobiliare.controllers;

import static org.junit.Assert.*;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.validation.BeanPropertyBindingResult;

import com.imobiliare.ImobiliareApplication;
import com.imobiliare.DTOs.UserDTO;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ImobiliareApplication.class)
@Transactional
public class UserControllerTest {
	@Autowired
	UserController userController;

	@SuppressWarnings("rawtypes")
	@Test
	public void saveUserThenExpectHttpStatusToBeCreated() throws InstantiationException, IllegalAccessException {
		UserDTO userDto = new UserDTO.UserDTOBuilder().email("email1@gmail.com").firstName("testUser").lastName("testUser")
				.phoneNumber("1233211231").create();
		ResponseEntity responseEntity = userController.save(userDto, new BeanPropertyBindingResult(userDto, "UserDTO"));
		ResponseEntity acResponseEntity = new ResponseEntity(HttpStatus.CREATED);
		assertEquals(responseEntity, acResponseEntity);
	}
}
