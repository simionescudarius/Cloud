package respositories;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class VirusTotalRepository extends AbstractRepository {
	private static final String API_URL = "https://www.virustotal.com/vtapi/v2/url/scan";
	private static final String URL_PARAM_NAME = "url";
	private static final String KEY_PARAM_NAME = "apikey";
	
	public VirusTotalRepository() {
		try {
			connection = configureUrlForRequest(HttpRequestMethods.POST, API_URL);
			addTimeoutsToRequest(5000, 5000);
		} catch (IOException e) {
			LOGGER.error(e.getMessage());
			LOGGER.error(e.getStackTrace());
		}
	}
	
	public String scanUrl(String urlToScan, String apiKey){
		try {
			addParametersToConnection(buildMapWithParameters(urlToScan, apiKey));
			return retrieveResponseFromRequest();
		} catch (IOException e) {
			LOGGER.error(e.getMessage());
			LOGGER.error(e.getStackTrace());
			return null;
		}
	}
	
	private Map<String, String> buildMapWithParameters(String urlToScan, String apiKey){
		Map<String, String> parametersMap = new HashMap<String, String>();
		parametersMap.put(URL_PARAM_NAME, urlToScan);
		parametersMap.put(KEY_PARAM_NAME, apiKey);
		
		return parametersMap;
	}
}
