package respositories;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;

import org.apache.log4j.Logger;

import tema1.Server;

public abstract class AbstractRepository {
	protected static final Logger LOGGER = Logger.getLogger(Server.class);
	protected HttpURLConnection connection;

	protected HttpURLConnection configureUrlForRequest(HttpRequestMethods method, String urlRequest)
			throws IOException {
		URL url = new URL(urlRequest);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod(method.name());
		return connection;
	}

	protected void addParametersToConnection(Map<String, String> parameters)
			throws UnsupportedEncodingException, IOException {
		LOGGER.debug("Adding parameters to connection..");
		connection.setDoOutput(true);
		DataOutputStream output = new DataOutputStream(connection.getOutputStream());
		output.writeBytes(getParamsString(parameters));
		output.flush();
		output.close();
	}

	protected void addHeadersToRequest(Map<String, String> headerValueMap) {
		LOGGER.debug("Adding headers to connection..");
		for (String header : headerValueMap.keySet()) {
			this.connection.setRequestProperty(header, headerValueMap.get(header));
		}
	}

	protected void addTimeoutsToRequest(int connectionTimeout, int readTimeout) {
		this.connection.setConnectTimeout(connectionTimeout);
		this.connection.setReadTimeout(readTimeout);
	}

	protected String retrieveResponseFromRequest() throws IOException {
		LOGGER.debug("Connection ready! \n");
		BufferedReader in = new BufferedReader(new InputStreamReader(retrieveInputStream()));
		LOGGER.debug("Getting data from response..!");
		String inputLine;
		StringBuffer content = new StringBuffer();
		while ((inputLine = in.readLine()) != null) {
			content.append(inputLine);
		}
		in.close();
		
		LOGGER.info("Response: ".concat(content.toString()));
		return content.toString();
	}

	private InputStream retrieveInputStream() throws IOException {
		LOGGER.debug("Making HTTP request..");
		LOGGER.debug("Request type: ".concat(this.connection.getRequestMethod()));
		LOGGER.debug("Request URL: ".concat(this.connection.getURL().toString()));
		
		if (this.connection.getDoOutput()) {
			LOGGER.debug("Request params: ".concat(this.connection.getOutputStream().toString()));
		}
		
		int responseStatus = this.connection.getResponseCode();
		LOGGER.debug("HTTP request done! Code: ".concat(String.valueOf(responseStatus)));
		return responseStatus > 299 ? this.connection.getErrorStream() : this.connection.getInputStream();
	}

	private String getParamsString(Map<String, String> params) throws UnsupportedEncodingException {
		StringBuilder result = new StringBuilder();

		for (Map.Entry<String, String> entry : params.entrySet()) {
			result.append(URLEncoder.encode(entry.getKey(), "UTF-8"));
			result.append("=");
			result.append(URLEncoder.encode(entry.getValue(), "UTF-8"));
			result.append("&");
		}

		String resultString = result.toString();
		return resultString.length() > 0 ? resultString.substring(0, resultString.length() - 1) : resultString;
	}
}
