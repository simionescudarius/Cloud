package com.tema3.prime.beans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;

import com.tema3.prime.model.TranslateModel;
import com.tema3.prime.services.GoogleTranslateService;

@ManagedBean(name = "translateBean")
public class TranslateBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private GoogleTranslateService googleTranslateService = new GoogleTranslateService();
	private TranslateModel translateModel = new TranslateModel();

	public void translateText(String sourceLanguage, String targetLanguage) {
		String translatedText = googleTranslateService.translateText(translateModel.getTextToBeTranslated(),
				sourceLanguage, targetLanguage);
		translateModel.setTranslatedText(translatedText);
	}

	public GoogleTranslateService getGoogleTranslateService() {
		return googleTranslateService;
	}

	public TranslateModel getTranslateModel() {
		return translateModel;
	}

}
