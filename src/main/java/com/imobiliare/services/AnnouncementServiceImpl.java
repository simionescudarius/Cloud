package com.imobiliare.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imobiliare.models.Announcement;
import com.imobiliare.repositories.AnnouncementRepository;

@Service
@Transactional
public class AnnouncementServiceImpl implements AnnouncementService {
	@Autowired
	AnnouncementRepository announcementRepository;
	
	@Override
	public void save(Announcement object) {
		announcementRepository.save(object);
	}

	@Override
	public List<Announcement> getAll() {
		return announcementRepository.findAll();
	}

	@Override
	public Announcement getById(Long id) {
		return announcementRepository.findOne(id);
	}

	@Override
	public void delete(Long id) {
		announcementRepository.delete(id);
	}

}
