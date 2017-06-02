package com.imobiliare.controllers;

import static org.junit.Assert.*;

import java.util.List;

import javax.transaction.Transactional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.imobiliare.ImobiliareApplication;
import com.imobiliare.DTOs.AnnouncementDTO;
import com.imobiliare.DTOs.UserDTO;

@Transactional
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ImobiliareApplication.class)
public class AnnouncementControllerTest {

	@Autowired
	AnnouncementController announcementController;
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void whenRequestGetAllShouldReturnAllAnnouncementsDTO() {
		ResponseEntity<List<AnnouncementDTO>> responseEntity = announcementController.getAll();
		List <AnnouncementDTO> announcementDTOs = responseEntity.getBody();
		assertTrue(announcementDTOs != null);
	}

}
