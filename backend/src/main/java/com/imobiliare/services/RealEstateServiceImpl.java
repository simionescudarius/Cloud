package com.imobiliare.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imobiliare.models.RealEstate;
import com.imobiliare.repositories.RealEstateRepository;

@Service
@Transactional
public class RealEstateServiceImpl implements RealEstateService {
	@Autowired
	RealEstateRepository realEstateRepository;
	
	@Override
	public void save(RealEstate object) {
		realEstateRepository.save(object);
	}

	@Override
	public List<RealEstate> getAll() {
		return realEstateRepository.findAll();
	}

	@Override
	public RealEstate getById(Long id) {
		return realEstateRepository.findOne(id);
	}

	@Override
	public void delete(Long id) {
		realEstateRepository.delete(id);
	}

}
