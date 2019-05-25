package cloud.imobiliare.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cloud.imobiliare.entities.FavouriteAnnouncement;
import cloud.imobiliare.entities.FavouritesKey;

@Repository
public interface FavouriteAnnouncementRepository extends JpaRepository<FavouriteAnnouncement, FavouritesKey> {
	List<FavouriteAnnouncement> findAllByUserId(long userId);
}