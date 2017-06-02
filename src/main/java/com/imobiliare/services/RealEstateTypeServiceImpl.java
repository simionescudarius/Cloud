package com.imobiliare.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imobiliare.models.RealEstateType;
import com.imobiliare.repositories.RealEstateTypeRepository;

@Service
@Transactional
public class RealEstateTypeServiceImpl implements RealEstateTypeService {
	@Autowired
	RealEstateTypeRepository realEstateTypeRepository;
	
	@Override
	public void save(RealEstateType object) {
		realEstateTypeRepository.save(object);
	}

	@Override
	public List<RealEstateType> getAll() {
		return realEstateTypeRepository.findAll();
	}

	@Override
	public RealEstateType getById(Long id) {
		return realEstateTypeRepository.findOne(id);
	}

	@Override
	public void delete(Long id) {
		realEstateTypeRepository.delete(id);
	}

}
