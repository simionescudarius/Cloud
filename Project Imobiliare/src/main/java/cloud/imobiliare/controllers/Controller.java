package cloud.imobiliare.controllers;

public abstract class Controller {
	protected static final int LEVEL_5_AUTH = 5;
	protected static final int LEVEL_4_AUTH = 4;
	protected static final int LEVEL_3_AUTH = 3;
	protected static final int LEVEL_2_AUTH = 2;
	protected static final int LEVEL_1_AUTH = 1;

	protected void validateNullData(Object... objects) throws IllegalArgumentException {
		for (Object object : objects) {
			if (object == null)
				throw new IllegalArgumentException("Received data is null !");
		}
	}

}
