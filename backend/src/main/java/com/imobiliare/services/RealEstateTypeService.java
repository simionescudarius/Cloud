package com.imobiliare.services;

import com.imobiliare.models.RealEstateType;

public interface RealEstateTypeService extends CrudService<RealEstateType, Long> {
	RealEstateType getByName (String name);
}
