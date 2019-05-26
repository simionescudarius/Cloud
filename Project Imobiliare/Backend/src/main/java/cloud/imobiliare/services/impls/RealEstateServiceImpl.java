package cloud.imobiliare.services.impls;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cloud.imobiliare.DTOs.RealEstateDTO;
import cloud.imobiliare.entities.RealEstate;
import cloud.imobiliare.repositories.RealEstateRepository;
import cloud.imobiliare.services.RealEstateService;
import cloud.imobiliare.transformers.RealEstateTransformer;

@Service
@Transactional
public class RealEstateServiceImpl implements RealEstateService {

	@Autowired
	private RealEstateRepository realEstateRepository;

	@Autowired
	private RealEstateTransformer realEstateTransformer;

	@Override
	public void save(RealEstateDTO object) {
		realEstateRepository.save(realEstateTransformer.toModel(object));
	}

	@Override
	public List<RealEstateDTO> getAll() {
		return realEstateTransformer.toDTOList(realEstateRepository.findAll());
	}

	@Override
	public RealEstateDTO getById(Long id) {
		Optional<RealEstate> realEstate = realEstateRepository.findById(id);

		if (realEstate.isPresent()) {
			return realEstateTransformer.toDTO(realEstate.get());
		}

		return null;
	}

	@Override
	public void delete(Long id) {
		realEstateRepository.deleteById(id);
	}

	public RealEstateRepository getRealEstateRepository() {
		return realEstateRepository;
	}

	public void setRealEstateRepository(RealEstateRepository realEstateRepository) {
		this.realEstateRepository = realEstateRepository;
	}

	public RealEstateTransformer getRealEstateTransformer() {
		return realEstateTransformer;
	}

	public void setRealEstateTransformer(RealEstateTransformer realEstateTransformer) {
		this.realEstateTransformer = realEstateTransformer;
	}

}
