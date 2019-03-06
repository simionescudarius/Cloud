package services;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.json.JSONObject;

import respositories.UploadRepository;
import util.GeneralConstants;

public class UploadService extends AbstractService {
	private UploadRepository uploadRepository;
	private String apiKey;

	public UploadService(String storeMethod, String fileUrl, String filename) {
		try {
			InputStream configFile = new FileInputStream(APY_KEY_FILE_PATH);
			Properties properties = new Properties();
			properties.load(configFile);
			apiKey = properties.getProperty(GeneralConstants.UPLOAD_PUBLIC_KEY);
		} catch (IOException e) {
			LOGGER.info("NO API KEY FILE, API KEY WILL BE EMPTY!");
			LOGGER.info(e.getStackTrace());
		}

		uploadRepository = new UploadRepository(apiKey, storeMethod, fileUrl, filename);
	}

	public String uploadFile() {
		String result = uploadRepository.uploadFile();
		JSONObject jsonObject = new JSONObject(result);

		return jsonObject.get("token").toString();
	}
}
