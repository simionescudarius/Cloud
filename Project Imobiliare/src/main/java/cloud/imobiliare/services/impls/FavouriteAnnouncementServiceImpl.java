package cloud.imobiliare.services.impls;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cloud.imobiliare.entities.FavouriteAnnouncement;
import cloud.imobiliare.entities.FavouritesKey;
import cloud.imobiliare.repositories.FavouriteAnnouncementRepository;
import cloud.imobiliare.services.FavouriteAnnouncementService;

@Service
public class FavouriteAnnouncementServiceImpl implements FavouriteAnnouncementService {
	@Autowired
	private FavouriteAnnouncementRepository favouriteAnnouncementRepository;

	@Override
	public void save(FavouriteAnnouncement object) {
		this.favouriteAnnouncementRepository.save(object);
	}

	@Override
	public List<FavouriteAnnouncement> getAll() {
		return this.favouriteAnnouncementRepository.findAll();
	}

	@Override
	public FavouriteAnnouncement getById(FavouritesKey id) {
		Optional<FavouriteAnnouncement> favAnnouncement = favouriteAnnouncementRepository.findById(id);

		if (favAnnouncement.isPresent()) {
			return favAnnouncement.get();
		}

		return null;
	}

	@Override
	public void delete(FavouritesKey id) {
		this.favouriteAnnouncementRepository.deleteById(id);
	}

	@Override
	public List<FavouriteAnnouncement> getFavourites(long id) {
		return this.favouriteAnnouncementRepository.findAllByUserId(id);
	}

}
