package util;

public enum HttpResponseCodes {
	OK(200), CREATED(201), NO_CONTENT(204), BAD_REQUEST(400);

	int statusCode;

	private HttpResponseCodes(int status) {
		this.statusCode = status;
	}

	public int getStatusCode() {
		return statusCode;
	}

}
