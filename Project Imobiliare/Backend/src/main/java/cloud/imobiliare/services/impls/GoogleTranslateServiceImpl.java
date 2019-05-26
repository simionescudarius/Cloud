package cloud.imobiliare.services.impls;

import org.springframework.stereotype.Service;

import com.google.cloud.translate.Translate;
import com.google.cloud.translate.Translate.TranslateOption;

import cloud.imobiliare.services.GoogleTranslateService;

import com.google.cloud.translate.TranslateOptions;
import com.google.cloud.translate.Translation;

@Service
public class GoogleTranslateServiceImpl implements GoogleTranslateService {

	private final Translate translateService = TranslateOptions.newBuilder().build().getService();

	public GoogleTranslateServiceImpl() {
	}

	@Override
	public String translateText(String text, String sourceLanguage, String targetLanguage) {
		TranslateOption sourceLanguageOption = TranslateOption.sourceLanguage(sourceLanguage);
		TranslateOption targetLanguageOption = TranslateOption.targetLanguage(targetLanguage);

		Translation translation = translateService.translate(text, sourceLanguageOption, targetLanguageOption);

		return translation.getTranslatedText();
	}

}
