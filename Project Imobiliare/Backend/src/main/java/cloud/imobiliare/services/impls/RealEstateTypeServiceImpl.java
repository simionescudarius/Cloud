package cloud.imobiliare.services.impls;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cloud.imobiliare.entities.RealEstateType;
import cloud.imobiliare.repositories.RealEstateTypeRepository;
import cloud.imobiliare.services.RealEstateTypeService;

@Service
@Transactional
public class RealEstateTypeServiceImpl implements RealEstateTypeService {
	@Autowired
	private RealEstateTypeRepository realEstateTypeRepository;

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
		Optional<RealEstateType> realEstate = realEstateTypeRepository.findById(id);

		if (realEstate.isPresent()) {
			return realEstate.get();
		}

		return null;
	}

	@Override
	public void delete(Long id) {
		realEstateTypeRepository.deleteById(id);
	}

	@Override
	public RealEstateType getByName(String name) {
		return realEstateTypeRepository.getByName(name);
	}
}
