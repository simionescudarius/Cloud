package cloud.imobiliare.services;

import java.util.List;

import cloud.imobiliare.entities.FavouriteAnnouncement;
import cloud.imobiliare.entities.FavouritesKey;
import cloud.imobiliare.services.common.CrudService;

public interface FavouriteAnnouncementService extends CrudService<FavouriteAnnouncement, FavouritesKey>{

	List<FavouriteAnnouncement> getFavourites(long id);
}