package com.imobiliare.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imobiliare.models.Zone;
import com.imobiliare.repositories.ZoneRepository;

@Service
@Transactional
public class ZoneServiceImpl implements ZoneService {
	@Autowired
	ZoneRepository zoneRepository;

	@Override
	public void save(Zone object) {
		zoneRepository.save(object);
	}

	@Override
	public List<Zone> getAll() {
		return zoneRepository.findAll();
	}

	@Override
	public Zone getById(Long id) {
		return zoneRepository.findOne(id);
	}

	@Override
	public void delete(Long id) {
		zoneRepository.delete(id);
	}

}
