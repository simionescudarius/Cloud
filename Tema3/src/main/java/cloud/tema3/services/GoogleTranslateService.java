package cloud.tema3.services;

public interface GoogleTranslateService {
	
	String translateText(String text, String sourceLanguage, String targetLanguage);
}
