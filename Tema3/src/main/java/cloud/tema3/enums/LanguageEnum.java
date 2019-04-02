package cloud.tema3.enums;

public enum LanguageEnum {
	RO("Romanian"), EN("English"), FR("French");

	private String description;

	private LanguageEnum(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}
}
