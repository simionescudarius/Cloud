package cloud.imobiliare.services.impls;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import cloud.imobiliare.DTOs.AnnouncementDTO;
import cloud.imobiliare.entities.Announcement;
import cloud.imobiliare.repositories.AnnouncementRepository;
import cloud.imobiliare.services.AnnouncementService;
import cloud.imobiliare.transformers.AnnouncementTransformer;

@Service
@Transactional
public class AnnouncementServiceImpl implements AnnouncementService {
	@Autowired
	private AnnouncementRepository announcementRepository;

	@Autowired
	private AnnouncementTransformer announcementTransformer;

	@Override
	public void save(AnnouncementDTO object) {
		announcementRepository.save(announcementTransformer.toModel(object));
	}

	@Override
	public List<AnnouncementDTO> getAll() {
		return announcementTransformer.toDTOList(announcementRepository.findAllByOrderByPostDateAsc());
	}

	@Override
	public AnnouncementDTO getById(Long id) {
		Optional<Announcement> announcement = announcementRepository.findById(id);

		if (announcement.isPresent()) {
			return announcementTransformer.toDTO(announcement.get());
		}

		return null;
	}

	@Override
	public void delete(Long id) {
		announcementRepository.deleteById(id);
	}

	@Override
	public List<AnnouncementDTO> getByRealEstateType(String type) {
		return announcementTransformer.toDTOList(announcementRepository.getByRealEstateType(type));
	}

	@Override
	public List<AnnouncementDTO> getByRealEstateRoomNumberAndType(int roomNumber, String type) {
		return announcementTransformer
				.toDTOList(announcementRepository.getByRealEstateRoomNumberAndType(roomNumber, type));
	}

	@Override
	public void incViewNumber(long id) {
		this.announcementRepository.incViewNumber(id);
	}

	@Override
	@SuppressWarnings("deprecation")
	public List<AnnouncementDTO> getMostPopular() {
		List<AnnouncementDTO> list = new ArrayList<>();
		Page<Announcement> page = announcementRepository
				.mostPopular(new PageRequest(0, 4, new Sort(Sort.Direction.DESC, "viewNumber")));
		page.forEach((k) -> list.add(announcementTransformer.toDTO(k)));
		return list;

	}

	@Override
	public List<AnnouncementDTO> getMyAnnouncements(long id) {
		return announcementTransformer.toDTOList(announcementRepository.findAllByOwnerId(id));
	}

	public AnnouncementRepository getAnnouncementRepository() {
		return announcementRepository;
	}

	public void setAnnouncementRepository(AnnouncementRepository announcementRepository) {
		this.announcementRepository = announcementRepository;
	}

	public AnnouncementTransformer getAnnouncementTransformer() {
		return announcementTransformer;
	}

	public void setAnnouncementTransformer(AnnouncementTransformer announcementTransformer) {
		this.announcementTransformer = announcementTransformer;
	}
}
