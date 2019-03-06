package tema1;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.StringTokenizer;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import services.AbstractService;
import services.RandomPhotoService;
import services.UploadService;
import services.VirusTotalService;
import util.GeneralConstants;

public final class Server implements Runnable {
	private static final Logger LOGGER = Logger.getLogger(Server.class);

	private final Socket clientConnection;
	private RandomPhotoService randomPhotoService = new RandomPhotoService();
	private VirusTotalService virusTotalService = new VirusTotalService();
	private UploadService uploadService;
	private String endpointRequested;

	public static void main(String[] args) {
		configureXMLLog4J();
		configureServices();
		try {
			startServer();
		} catch (IOException | InterruptedException e) {
			LOGGER.error(e.getMessage());
			LOGGER.error(e.getStackTrace());
		}
	}

	public Server(Socket connection) {
		this.clientConnection = connection;
	}

	@Override
	public void run() {
		if (checkIfClientRequestIsValid()) {
			if (endpointRequested.equalsIgnoreCase(GeneralConstants.LOGS_ENDPOINT)) {
				try {
					File logsFile = new File("logs.txt");
					byte[] fileBites = new byte[(int) logsFile.length()];
					FileInputStream fileInputStream = new FileInputStream(logsFile);
					BufferedInputStream bufferInputStream = new BufferedInputStream(fileInputStream);
					bufferInputStream.read(fileBites, 0, fileBites.length);
					writeResponseToClient(fileBites);
					bufferInputStream.close();
				} catch (IOException e) {
					LOGGER.error(e.getMessage());
					LOGGER.error(e.getStackTrace());
				}
			} else {
				try {
					String randomPhotoUrl = randomPhotoService.retrievePhotoUrl();
					String virusTotalReportId = virusTotalService.scanUrlAndGetReportId(randomPhotoUrl);

					uploadService = new UploadService(GeneralConstants.STORE_FILES, randomPhotoUrl, virusTotalReportId);
					String tokenOfUploadedFile = uploadService.uploadFile();
					String resultForClient = prepareResponseForClient(tokenOfUploadedFile);

					writeResponseToClient(resultForClient);
				} catch (IOException e) {
					LOGGER.error(e.getMessage());
					LOGGER.error(e.getStackTrace());
				} finally {
					try {
						clientConnection.close();
						LOGGER.debug("Connection is closed. \n\n");
					} catch (IOException e) {
						LOGGER.error(e.getMessage());
						LOGGER.error(e.getStackTrace());
					}
				}
			}
		}
	}

	private String prepareResponseForClient(String tokenOfUploadedFile) {
		StringBuilder finalResult = new StringBuilder();
		StringBuilder infoAboutCheckUploadedFile = new StringBuilder();
		infoAboutCheckUploadedFile.append(GeneralConstants.CHECK_FILE_API_URL);
		infoAboutCheckUploadedFile.append(tokenOfUploadedFile);

		finalResult.append(GeneralConstants.returnPageFirstHalf).append(infoAboutCheckUploadedFile)
				.append(GeneralConstants.returnPageSecondHalf);

		return finalResult.toString();
	}

	private boolean checkIfClientRequestIsValid() {
		String method = "";
		endpointRequested = "";
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(clientConnection.getInputStream()));
			String input = in.readLine();
			if (input == null) {
				return false;
			}
			StringTokenizer parse = new StringTokenizer(input);
			method = parse.nextToken().toUpperCase();
			endpointRequested = parse.nextToken().toLowerCase();
		} catch (IOException e) {
			LOGGER.error(e.getMessage());
			LOGGER.error(e.getStackTrace());
		}

		if (!method.equalsIgnoreCase("GET") || (!endpointRequested.equalsIgnoreCase(GeneralConstants.ABSOLUTE_ENDPOINT)
				&& !endpointRequested.equalsIgnoreCase(GeneralConstants.LOGS_ENDPOINT))) {
			try {
				sendWrongRequestResponse();
				LOGGER.info("Wrong request! Action: ".concat(method).concat("  Endpoint: ").concat(endpointRequested));
			} catch (IOException e) {
				LOGGER.error(e.getMessage());
				LOGGER.error(e.getStackTrace());
			}

			return false;
		}

		return true;
	}

	private void sendWrongRequestResponse() throws IOException {
		PrintWriter headerWriter = new PrintWriter(clientConnection.getOutputStream());
		BufferedOutputStream responseWriter = new BufferedOutputStream(clientConnection.getOutputStream());
		String messageWrongRequest = "Wrong request!";

		headerWriter.println("HTTP/1.1 400 BAD REQUEST");
		headerWriter.println("Java HTTP Server Cloud-Computing");
		headerWriter.println("Date: " + new Date());
		headerWriter.println("Content-type: " + "text/html");
		headerWriter.println("Content-length: " + messageWrongRequest.getBytes().length);
		headerWriter.println();
		headerWriter.flush();

		responseWriter.write(messageWrongRequest.getBytes(), 0, messageWrongRequest.getBytes().length);
		responseWriter.flush();

		clientConnection.close();
	}

	private void writeResponseToClient(String stringData) throws IOException {
		PrintWriter headerWriter = new PrintWriter(clientConnection.getOutputStream());
		BufferedOutputStream responseWriter = new BufferedOutputStream(clientConnection.getOutputStream());

		byte[] data = stringData.getBytes();

		headerWriter.println("HTTP/1.1 200 OK");
		headerWriter.println("Java HTTP Server Cloud-Computing");
		headerWriter.println("Date: " + new Date());
		headerWriter.println("Content-type: " + "text/html");
		headerWriter.println("Content-length: " + data.length);
		headerWriter.println();
		headerWriter.flush();

		responseWriter.write(data, 0, data.length);
		responseWriter.flush();
	}

	private void writeResponseToClient(byte[] file) throws IOException {
		PrintWriter headerWriter = new PrintWriter(clientConnection.getOutputStream());
		BufferedOutputStream responseWriter = new BufferedOutputStream(clientConnection.getOutputStream());

		headerWriter.println("HTTP/1.1 200 OK");
		headerWriter.println("Java HTTP Server Cloud-Computing");
		headerWriter.println("Date: " + new Date());
		headerWriter.println("Content-type: " + "text");
		headerWriter.println("Content-length: " + file.length);
		headerWriter.println();
		headerWriter.flush();

		responseWriter.write(file, 0, file.length);
		responseWriter.flush();
	}

	private static void configureXMLLog4J() {
		StringBuilder log4jConfigFilePath = new StringBuilder(System.getProperty("user.dir"));
		log4jConfigFilePath.append(File.separator);
		log4jConfigFilePath.append(GeneralConstants.PATH_TO_RESOURCES);
		log4jConfigFilePath.append(File.separator);
		log4jConfigFilePath.append(GeneralConstants.LOGGER_CONFIG_FILE);
		DOMConfigurator.configure(log4jConfigFilePath.toString());
	}

	private static void configureServices() {
		StringBuilder apiKeysFilePath = new StringBuilder(System.getProperty("user.dir"));
		apiKeysFilePath.append(File.separator);
		apiKeysFilePath.append(GeneralConstants.PATH_TO_RESOURCES);
		apiKeysFilePath.append(File.separator);
		apiKeysFilePath.append(GeneralConstants.API_KEYS_FILE);

		AbstractService.APY_KEY_FILE_PATH = apiKeysFilePath.toString();
	}

	@SuppressWarnings("resource")
	private static void startServer() throws IOException, InterruptedException {
		ServerSocket serverSocket = new ServerSocket(GeneralConstants.SERVER_PORT);
		LOGGER.info("Server started.");

		while (true) {
			Server createdServer = new Server(serverSocket.accept());
			LOGGER.info("Connection accepted.");

			Thread thread = new Thread(createdServer);
			thread.run();
		}
	}
}
