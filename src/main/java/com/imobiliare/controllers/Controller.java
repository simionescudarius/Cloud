package com.imobiliare.controllers;

public abstract class Controller {
	void validateNullData(Object... objects) throws IllegalArgumentException {
		for (Object object : objects) {
			if (object == null)
				throw new IllegalArgumentException("Received data is null !");
		}
	}
}
