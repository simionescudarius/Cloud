package respositories;

import java.io.IOException;

public class RandomPhotoRepository extends AbstractRepository {
	private static final String API_URL = "http://www.splashbase.co/api/v1/images/random";
	
	public RandomPhotoRepository() {
		try {
			this.connection = configureUrlForRequest(HttpRequestMethods.GET, API_URL);
			addTimeoutsToRequest(50000, 50000);
		} catch (IOException e) {
			LOGGER.error(e.getMessage());
			LOGGER.error(e.getStackTrace());
		}
	}
	
	public String retrieveRandomPhoto() {
		try {
			return retrieveResponseFromRequest();
		} catch (IOException e) {
			LOGGER.error(e.getMessage());
			LOGGER.error(e.getStackTrace());
			return null;
		}
	}
}
