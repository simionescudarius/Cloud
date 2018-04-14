package com.tema3.prime.services;

import com.google.cloud.translate.Translate;
import com.google.cloud.translate.Translate.TranslateOption;
import com.google.cloud.translate.TranslateOptions;
import com.google.cloud.translate.Translation;

public class GoogleTranslateService {

	private final Translate translateService = TranslateOptions.newBuilder().build().getService();

	public GoogleTranslateService() {
	}

	public String translateText(String sourceText, String sourceLanguage, String targetLanguage) {
		TranslateOption sourceLanguageOption = TranslateOption.sourceLanguage(sourceLanguage);
		TranslateOption targetLanguageOption = TranslateOption.targetLanguage(targetLanguage);

		Translation translation = translateService.translate(sourceText, sourceLanguageOption, targetLanguageOption);

		return translation.getTranslatedText();
	}

}
