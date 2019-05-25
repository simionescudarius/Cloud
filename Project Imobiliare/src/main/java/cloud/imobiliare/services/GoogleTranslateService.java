package cloud.imobiliare.services;

public interface GoogleTranslateService {
	
	String translateText(String text, String sourceLanguage, String targetLanguage);
}
