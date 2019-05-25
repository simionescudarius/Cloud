package cloud.imobiliare.services;

import cloud.imobiliare.entities.RealEstateType;
import cloud.imobiliare.services.common.CrudService;

public interface RealEstateTypeService extends CrudService<RealEstateType, Long> {
	RealEstateType getByName (String name);
}
