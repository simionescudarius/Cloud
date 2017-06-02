package com.imobiliare.enums;

public enum UserUpdateEnum {
	FIRSTNAME, LASTNAME, EMAIL, PHONENUMBER;

	public static UserUpdateEnum toEnum (String option){
		switch (option) {
		case "first name": return FIRSTNAME;
		case "last name" : return LASTNAME;
		case "email" : return EMAIL;
		case "phone number" : return PHONENUMBER;
		default: throw new IllegalArgumentException("Wrong update option !");	
		}
	}
}
