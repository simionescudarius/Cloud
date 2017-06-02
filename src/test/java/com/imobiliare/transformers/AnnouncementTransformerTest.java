package com.imobiliare.transformers;

import static org.junit.Assert.*;

import java.sql.Date;

import javax.transaction.Transactional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.imobiliare.ImobiliareApplication;
import com.imobiliare.models.Announcement;
import com.imobiliare.services.AnnouncementService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ImobiliareApplication.class)
@Transactional
public class AnnouncementTransformerTest {
	@Autowired
	AnnouncementService announcementService;
	
	AnnouncementTransformer announcementTransformer;
	Announcement announcement;
	
	@Before
	public void setUp() throws Exception {
		announcement = new Announcement();
		announcement.setExpireDate(Date.valueOf("2017-05-31"));
	}

	@Test
	public void getByIdTest() {
		assertTrue(announcement != null);
	}

}
