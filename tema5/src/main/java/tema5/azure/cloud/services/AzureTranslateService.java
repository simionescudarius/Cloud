package tema5.azure.cloud.services;

public interface AzureTranslateService {
	
	String translateText(String text, String sourceLanguage, String targetLanguage);
}
