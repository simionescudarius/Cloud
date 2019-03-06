package respositories;

import java.io.IOException;

public class UploadRepository extends AbstractRepository {
	private static final String GENERAL_API_URL = "https://upload.uploadcare.com/from_url/?";
	private static final String PUBLIC_KEY_API = "pub_key=";
	private static final String STORE_METHOD_API = "store=";
	private static final String SOURCE_URL = "source_url=";
	private static final String FILENAME = "filename=";
	private static final String SEPARATOR = "&";
	private static String FINAL_URL = "";

	public UploadRepository(String publicKey, String storeMethod, String fileUrl, String filename) {
		try {
			buildUrlForRequest(publicKey, storeMethod, fileUrl, filename);
			connection = configureUrlForRequest(HttpRequestMethods.POST, FINAL_URL);
			addTimeoutsToRequest(5000, 5000);
		} catch (IOException e) {
			LOGGER.error(e.getMessage());
			LOGGER.error(e.getStackTrace());
		}
	}

	public String uploadFile() {
		try {
			return retrieveResponseFromRequest();
		} catch (IOException e) {
			LOGGER.error(e.getMessage());
			LOGGER.error(e.getStackTrace());
			return null;
		}
	}

	private void buildUrlForRequest(String publicKey, String storeMethod, String fileUrl, String filename) {
		StringBuilder finalUrl = new StringBuilder(GENERAL_API_URL);
		finalUrl.append(PUBLIC_KEY_API);
		finalUrl.append(publicKey).append(SEPARATOR);
		finalUrl.append(STORE_METHOD_API);
		finalUrl.append(storeMethod).append(SEPARATOR);
		finalUrl.append(SOURCE_URL);
		finalUrl.append(fileUrl).append(SEPARATOR);
		finalUrl.append(FILENAME).append(filename);

		FINAL_URL = finalUrl.toString();
	}
}
