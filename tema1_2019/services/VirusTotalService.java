package services;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.json.JSONObject;

import respositories.VirusTotalRepository;
import util.GeneralConstants;

public class VirusTotalService extends AbstractService {
	private VirusTotalRepository virusTotalRepository = new VirusTotalRepository();
	private String apiKey;
	
	public VirusTotalService() {
		try {
			InputStream configFile = new FileInputStream(APY_KEY_FILE_PATH);
			Properties properties = new Properties();
			properties.load(configFile);
			apiKey = properties.getProperty(GeneralConstants.VIRUS_TOTAL_KEY);
		} catch (IOException e) {
			LOGGER.info("NO API KEY FILE, API KEY WILL BE EMPTY!");
			LOGGER.info(e.getStackTrace());
		}
	}
	
	public String scanUrl(String url) {
		return virusTotalRepository.scanUrl(url, apiKey);
	}
	
	public String scanUrlAndGetReportId(String url) {
		String result = virusTotalRepository.scanUrl(url, apiKey);
		JSONObject jsonObject = new JSONObject(result);
		
		return jsonObject.get("scan_id").toString();
	}
}
