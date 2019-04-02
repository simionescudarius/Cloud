package cloud.tema3.services.impls;

import org.springframework.stereotype.Service;

import com.google.cloud.translate.Translate;
import com.google.cloud.translate.Translate.TranslateOption;
import com.google.cloud.translate.TranslateOptions;
import com.google.cloud.translate.Translation;

import cloud.tema3.services.GoogleTranslateService;

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
