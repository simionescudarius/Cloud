package cloud.imobiliare.services.impls;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cloud.imobiliare.DTOs.ZoneDTO;
import cloud.imobiliare.entities.Zone;
import cloud.imobiliare.repositories.ZoneRepository;
import cloud.imobiliare.services.ZoneService;
import cloud.imobiliare.transformers.ZoneTransformer;

@Service
@Transactional
public class ZoneServiceImpl implements ZoneService {
	@Autowired
	private ZoneRepository zoneRepository;

	@Autowired
	private ZoneTransformer zoneTransformer;

	@Override
	public void save(ZoneDTO object) {
		zoneRepository.save(zoneTransformer.toModel(object));
	}

	@Override
	public List<ZoneDTO> getAll() {
		return zoneTransformer.toDTOList(zoneRepository.findAll());
	}

	@Override
	public ZoneDTO getById(Long id) {

		Optional<Zone> zone = zoneRepository.findById(id);

		if (zone.isPresent()) {
			return zoneTransformer.toDTO(zone.get());
		}

		return null;
	}

	@Override
	public void delete(Long id) {
		zoneRepository.deleteById(id);
	}

	public ZoneRepository getZoneRepository() {
		return zoneRepository;
	}

	public void setZoneRepository(ZoneRepository zoneRepository) {
		this.zoneRepository = zoneRepository;
	}

	public ZoneTransformer getZoneTransformer() {
		return zoneTransformer;
	}

	public void setZoneTransformer(ZoneTransformer zoneTransformer) {
		this.zoneTransformer = zoneTransformer;
	}

}
