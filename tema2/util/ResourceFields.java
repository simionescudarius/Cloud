package util;

public enum ResourceFields {
	RESOURCE_NAME_FIELD("name"),
	RESOURCE_DESC_FIELD("description"),
	RESOURCE_SIZE_FIELD("size");

	private String variableName;

	private ResourceFields(String variableName) {
		this.variableName = variableName;
	}

	public String getVariableName() {
		return variableName;
	}
}

