package tema5.azure.cloud.DTOs;

import java.io.Serializable;

import tema5.azure.cloud.enums.LanguageEnum;

public class TranslateDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private String text = "merge?";
	private LanguageEnum sourceLanguage;
	private LanguageEnum targetLanguage;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public LanguageEnum getSourceLanguage() {
		return sourceLanguage;
	}

	public void setSourceLanguage(LanguageEnum sourceLanguage) {
		this.sourceLanguage = sourceLanguage;
	}

	public LanguageEnum getTargetLanguage() {
		return targetLanguage;
	}

	public void setTargetLanguage(LanguageEnum targetLanguage) {
		this.targetLanguage = targetLanguage;
	}
}
