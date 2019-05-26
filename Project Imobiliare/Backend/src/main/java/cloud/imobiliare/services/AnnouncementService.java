package cloud.imobiliare.services;

import java.util.List;

import cloud.imobiliare.DTOs.AnnouncementDTO;
import cloud.imobiliare.services.common.CrudService;

public interface AnnouncementService extends CrudService<AnnouncementDTO, Long> {
	List<AnnouncementDTO> getByRealEstateType (String type);
	List<AnnouncementDTO> getByRealEstateRoomNumberAndType(int roomNumber, String type);
	List<AnnouncementDTO> getMostPopular();
	List<AnnouncementDTO> getMyAnnouncements(long id);
	void incViewNumber (long id);
}
