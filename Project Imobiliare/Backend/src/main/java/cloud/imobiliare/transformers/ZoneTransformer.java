package cloud.imobiliare.transformers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import cloud.imobiliare.DTOs.ZoneDTO;
import cloud.imobiliare.entities.Zone;

@Component
public class ZoneTransformer implements Transformer<Zone, ZoneDTO> {

	@Override
	public ZoneDTO toDTO(Zone object) {
		return new ZoneDTO.ZoneBuilder().barsNearby(toBoolean(object.getBarsNearby()))
				.chimicPollution(object.getChimicPollution())
				.entertainmentNearby(toBoolean(object.getEntertainmentNearby()))
				.greatView(toBoolean(object.getGreatView())).hardReachable(toBoolean(object.getHardReachable()))
				.id(object.getId()).latitude(object.getLatitude()).longitude(object.getLongitude())
				.noisePollution(object.getNoisePollution()).parking(toBoolean(object.getParking()))
				.postalCode(object.getPostalCode()).publicTransportNearby(toBoolean(object.getPublicTransportNearby()))
				.shopsNearby(toBoolean(object.getShopsNearby())).wastePollution(object.getWastePollution())
				.name(object.getName()).create();
	}

	@Override
	public Zone toModel(ZoneDTO object) {
		return new Zone.ZoneBuilder().barsNearby(object.isBarsNearby()).chimicPollution(object.getChimicPollution())
				.entertainmentNearby(object.isEntertainmentNearby()).greatView(object.isGreatView())
				.hardReachable(object.isHardReachable()).latitude(object.getLatitude()).longitude(object.getLongitude())
				.noisePollution(object.getNoisePollution()).parking(object.isParking())
				.postalCode(object.getPostalCode()).publicTransportNearby(object.isPublicTransportNearby())
				.shopsNearby(object.isShopsNearby()).wastePollution(object.getWastePollution()).name(object.getName())
				.create();
	}
	
	public List<ZoneDTO> toDTOList(List<Zone> models) {
		if (models == null) {
			return new ArrayList<>();
		}

		List<ZoneDTO> dtos = new ArrayList<>();
		models.forEach(model -> dtos.add(toDTO(model)));
		return dtos;

	}

	private boolean toBoolean(Byte value) {
		if (value == null)
			return false;
		switch (value.byteValue()) {
		case 0:
			return false;
		default:
			return true;
		}
	}
}
