package com.imobiliare.services;

import static org.junit.Assert.*;

import javax.transaction.Transactional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.imobiliare.ImobiliareApplication;
import com.imobiliare.models.User;
import com.imobiliare.repositories.UserRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ImobiliareApplication.class)
@Transactional
public class UserRepositoryTest {

	@Autowired
	UserRepository userRepository;
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void findOneTest() {
		User user = userRepository.findOne((long) 234);
		assertTrue(user != null);
	}

	@Test
	public void updateFirstNameTest(){
		userRepository.updateFirstName(234, "upTest");
		User user = userRepository.findOne(234L);
		assertTrue(user.getFirstName().equals("upTest"));
	}
}
