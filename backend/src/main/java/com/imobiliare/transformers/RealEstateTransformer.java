package com.imobiliare.transformers;

import org.springframework.stereotype.Component;

import com.imobiliare.DTOs.RealEstateDTO;
import com.imobiliare.DTOs.RealEstateTypeDTO;
import com.imobiliare.models.RealEstate;

@Component
public class RealEstateTransformer implements Transformer<RealEstate, RealEstateDTO> {

	@Override
	public RealEstateDTO toDTO(RealEstate object) {
		return new RealEstateDTO(object.getId(),
				new RealEstateTypeDTO(object.getType().getId(), object.getType().getName()),
				new ZoneTransformer().toDTO(object.getZone()), object.getArea(), object.getRoomNumber());
	}

	@Override
	public RealEstate toModel(RealEstateDTO object) {
		return new RealEstate(object.getType().getId(), object.getZone().getId(), object.getArea(),
				object.getRoomNumber());
	}
}
