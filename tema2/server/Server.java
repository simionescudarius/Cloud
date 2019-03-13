package server;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import repository.ResourceRepository;
import store.Resource;
import util.GeneralConstants;
import util.HttpMethodsAccepted;
import util.HttpResponseCodes;
import util.ResourceFields;

public final class Server {
	private static final Logger LOGGER = Logger.getLogger(Server.class);
	private static final ResourceRepository resourceRepository = new ResourceRepository();

	public static void main(String[] args) {
		try {
			configureXMLLog4J();
			startServer();
		} catch (IOException e) {
			LOGGER.error(e.getMessage());
			LOGGER.error(e.getStackTrace());
		}
	}

	private static class SingleResourceHandler implements HttpHandler {

		@Override
		public void handle(HttpExchange exchange) throws IOException {
			String[] uri = exchange.getRequestURI().toString().split("/");

			if (HttpMethodsAccepted.POST.name().equalsIgnoreCase(exchange.getRequestMethod())) {
				if (uri.length != 2) {
					writeResponseToClient(exchange, new byte[0], HttpResponseCodes.BAD_REQUEST);
					throw new IllegalArgumentException();
				}

				Resource inResource = parseStringToResource(exchange, readRequestBody(exchange));
				writeResponseToClient(exchange,
						new JSONObject(resourceRepository.createResource(inResource)).toString().getBytes(),
						HttpResponseCodes.CREATED);
				return;
			}

			if (uri.length != 3 || !uri[2].matches("[0-9]+")) {
				writeResponseToClient(exchange, new byte[0], HttpResponseCodes.BAD_REQUEST);
				throw new IllegalArgumentException();
			}

			int resourceId = Integer.parseInt(uri[2]);
			Resource resource = resourceRepository.retrieveResourceById(resourceId);

			if (resource == null) {
				writeResponseToClient(exchange, new byte[0], HttpResponseCodes.NO_CONTENT);
				throw new IllegalArgumentException();
			}

			if (HttpMethodsAccepted.GET.name().equalsIgnoreCase(exchange.getRequestMethod())) {
				writeResponseToClient(exchange, new JSONObject(resource).toString().getBytes(), HttpResponseCodes.OK);

			} else if (HttpMethodsAccepted.PUT.name().equalsIgnoreCase(exchange.getRequestMethod())) {
				Resource inResource = parseStringToResource(exchange, readRequestBody(exchange));
				resource.setDescription(inResource.getDescription());
				resource.setName(inResource.getName());
				resource.setSize(inResource.getSize());

				writeResponseToClient(exchange, new JSONObject(resource).toString().getBytes(), HttpResponseCodes.OK);
			} else if (HttpMethodsAccepted.DELETE.name().equalsIgnoreCase(exchange.getRequestMethod())) {
				resourceRepository.deleteResource(resourceId);
				writeResponseToClient(exchange, new byte[0], HttpResponseCodes.OK);
				throw new IllegalArgumentException();
			}
		}
	}

	private static class MultipleResourceHandler implements HttpHandler {
		@Override
		public void handle(HttpExchange exchange) throws IOException {
			if (HttpMethodsAccepted.GET.name().equalsIgnoreCase(exchange.getRequestMethod())) {
				writeResponseToClient(exchange,
						prepareResponseAsJson(resourceRepository.retrieveAllResources()).toString().getBytes(),
						HttpResponseCodes.OK);
			} else if (HttpMethodsAccepted.POST.name().equalsIgnoreCase(exchange.getRequestMethod())) {
				String requestBody = readRequestBody(exchange);

				if (requestBody.isEmpty()) {
					writeResponseToClient(exchange, new byte[0], HttpResponseCodes.BAD_REQUEST);
					throw new IllegalArgumentException();
				}

				List<Resource> inputResources = parseMultipleStringsToResources(exchange, requestBody);
				List<Resource> createdResources = new ArrayList<>();
				for (Resource resource : inputResources) {
					createdResources.add(resourceRepository.createResource(resource));
				}

				writeResponseToClient(exchange, prepareResponseAsJson(createdResources).toString().getBytes(),
						HttpResponseCodes.CREATED);
			} else if (HttpMethodsAccepted.DELETE.name().equalsIgnoreCase(exchange.getRequestMethod())) {
				if (resourceRepository.retrieveAllResources().isEmpty()) {
					writeResponseToClient(exchange, new byte[0], HttpResponseCodes.NO_CONTENT);
					return;
				}

				resourceRepository.deleteAllResources();
				writeResponseToClient(exchange,
						prepareResponseAsJson(resourceRepository.retrieveAllResources()).toString().getBytes(),
						HttpResponseCodes.OK);
			}
		}

	}

	private static String readRequestBody(HttpExchange exchange) throws IOException {
		InputStreamReader inputStream = new InputStreamReader(exchange.getRequestBody(), "utf-8");
		BufferedReader buffer = new BufferedReader(inputStream);

		int bytes;
		StringBuilder requestBody = new StringBuilder(1024);
		while ((bytes = buffer.read()) != -1) {
			requestBody.append((char) bytes);
		}

		buffer.close();
		inputStream.close();

		return requestBody.toString();
	}

	private static List<Resource> parseMultipleStringsToResources(HttpExchange exchange, String multipleResourcesString)
			throws IOException {
		JSONObject jsonObject;

		try {
			jsonObject = new JSONObject(multipleResourcesString);
		} catch (JSONException exception) {
			LOGGER.error(exception.getMessage());
			LOGGER.error(exception.getStackTrace());
			writeResponseToClient(exchange, new byte[0], HttpResponseCodes.BAD_REQUEST);
			throw new IllegalArgumentException();
		}

		JSONArray jsonArray = null;
		try {
			jsonArray = jsonObject.getJSONArray("resources");
		} catch (JSONException exception) {
			LOGGER.error(exception.getMessage());
			LOGGER.error(exception.getStackTrace());
			writeResponseToClient(exchange, new byte[0], HttpResponseCodes.BAD_REQUEST);
			throw new IllegalArgumentException();
		}

		List<Resource> resources = new ArrayList<>();

		for (int index = 0; index < jsonArray.length(); ++index) {
			JSONObject json = jsonArray.getJSONObject(index);
			resources.add(parseStringToResource(exchange, json.toString()));
		}

		return resources;
	}

	private static Resource parseStringToResource(HttpExchange exchange, String resourceString) throws IOException {
		Resource resource = new Resource();

		JSONObject object;

		try {
			object = new JSONObject(resourceString);
		} catch (JSONException exception) {
			LOGGER.error(exception.getMessage());
			LOGGER.error(exception.getStackTrace());
			writeResponseToClient(exchange, new byte[0], HttpResponseCodes.BAD_REQUEST);
			throw new IllegalArgumentException();
		}

		for (ResourceFields resourceField : ResourceFields.values()) {
			try {
				object.get(resourceField.getVariableName());
			} catch (JSONException exception) {
				LOGGER.error(exception.getMessage());
				LOGGER.error(exception.getStackTrace());
				writeResponseToClient(exchange, new byte[0], HttpResponseCodes.BAD_REQUEST);
				throw new IllegalArgumentException();
			}
		}

		resource.setDescription(object.getString(ResourceFields.RESOURCE_DESC_FIELD.getVariableName()));
		resource.setName(object.getString(ResourceFields.RESOURCE_NAME_FIELD.getVariableName()));
		resource.setSize(object.getInt(ResourceFields.RESOURCE_SIZE_FIELD.getVariableName()));

		return resource;
	}

	private static void writeResponseToClient(HttpExchange exchange, byte[] response,
			HttpResponseCodes httpResponseCode) throws IOException {
		exchange.getResponseHeaders().set(GeneralConstants.CONTENT_HEADER, "application/json");
		exchange.sendResponseHeaders(httpResponseCode.getStatusCode(), response.length);
		OutputStream os = exchange.getResponseBody();
		os.write(response);
		os.close();
	}

	private static void startServer() throws IOException {
		HttpServer server = HttpServer.create(new InetSocketAddress(GeneralConstants.SERVER_PORT), 0);
		server.createContext("/resources", new MultipleResourceHandler());
		server.createContext("/resource", new SingleResourceHandler());
		server.setExecutor(null);
		server.start();
		LOGGER.debug("SERVER STARTED");
	}

	private static List<JSONObject> prepareResponseAsJson(List<Resource> resources) {
		List<JSONObject> jsonObjects = new ArrayList<>();

		for (Resource resource : resources) {
			JSONObject object = new JSONObject(resource);
			jsonObjects.add(object);
		}

		return jsonObjects;
	}

	private static void configureXMLLog4J() {
		StringBuilder log4jConfigFilePath = new StringBuilder(System.getProperty("user.dir"));
		log4jConfigFilePath.append(File.separator);
		log4jConfigFilePath.append(GeneralConstants.PATH_TO_RESOURCES);
		log4jConfigFilePath.append(File.separator);
		log4jConfigFilePath.append(GeneralConstants.LOGGER_CONFIG_FILE);
		DOMConfigurator.configure(log4jConfigFilePath.toString());
	}
}
