package util;

public final class GeneralConstants {
	public static final int SERVER_PORT = 9090;
	
	public static final String DO_NOT_STORE_FILES = "0";
	public static final String STORE_FILES = "1";
	
	public static final String CHECK_FILE_API_URL = "https://upload.uploadcare.com/from_url/status/?token=";
	
	public static final String PATH_TO_RESOURCES = "resources";
	public static final String LOGGER_CONFIG_FILE = "log4j.xml";
	public static final String API_KEYS_FILE = "apikeys.properties";
	public static final String VIRUS_TOTAL_KEY = "key.virustotal";
	public static final String UPLOAD_PUBLIC_KEY = "key.uploadfile";
	public static final String ABSOLUTE_ENDPOINT = "/";
	public static final String LOGS_ENDPOINT = "/logs";
	
	public static final String returnPageFirstHalf = "<!DOCTYPE html> <html> <body> <h1>You can check uploaded file status at link:";
	public static final String returnPageSecondHalf = "</h1> </body> </html>";
}
