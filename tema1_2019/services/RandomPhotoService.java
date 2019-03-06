package services;


import org.json.JSONObject;

import respositories.RandomPhotoRepository;

public class RandomPhotoService extends AbstractService {
	private RandomPhotoRepository photoRepository = new RandomPhotoRepository();;
	
	public String retrievePhotoUrl() {
		JSONObject jsonObject = new JSONObject(photoRepository.retrieveRandomPhoto());
		return jsonObject.get("url").toString();
	}
}
