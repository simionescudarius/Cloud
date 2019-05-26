package cloud.imobiliare.transformers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import cloud.imobiliare.DTOs.RealEstateDTO;
import cloud.imobiliare.DTOs.RealEstateTypeDTO;
import cloud.imobiliare.entities.RealEstate;

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

	public List<RealEstateDTO> toDTOList(List<RealEstate> models) {
		if (models == null) {
			return new ArrayList<>();
		}

		List<RealEstateDTO> dtos = new ArrayList<>();
		models.forEach((k) -> dtos.add(toDTO(k)));
		return dtos;
	}
}
