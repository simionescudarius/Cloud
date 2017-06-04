package com.imobiliare.repositories;

import static org.junit.Assert.*;

import java.util.List;

import javax.transaction.Transactional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.imobiliare.ImobiliareApplication;
import com.imobiliare.models.Announcement;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ImobiliareApplication.class)
@Transactional
public class AnnouncementRepositoryTest {

	@Autowired
	AnnouncementRepository annoucementRepository;
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void getByTypeAndShouldBeString() {
		List<Announcement> list = annoucementRepository.getByRealEstateType("string");
		assertTrue(list.get(0).getRealEstate().getType().getName().equals("string"));
	}
	
	@Test
	public void getByTypeAndShouldBeAltTip() {
		List<Announcement> list = annoucementRepository.getByRealEstateType("altTip");
		assertTrue(list.get(0).getRealEstate().getType().getName().equals("altTip"));
	}
}
