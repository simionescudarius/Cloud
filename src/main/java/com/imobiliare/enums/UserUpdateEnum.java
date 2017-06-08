package com.imobiliare.enums;

public enum UserUpdateEnum {
	FIRSTNAME(5), LASTNAME(5), EMAIL(1), PHONENUMBER(1);
	
	private int reqAuthLevel;
	
	UserUpdateEnum (int reqAuthLevel){
		this.reqAuthLevel = reqAuthLevel;
	}

	public static UserUpdateEnum toEnum (String option){
		switch (option) {
		case "first name": return FIRSTNAME;
		case "last name" : return LASTNAME;
		case "email" : return EMAIL;
		case "phone number" : return PHONENUMBER;
		default: throw new IllegalArgumentException("Wrong update option !");	
		}
	}

	public int getReqAuthLevel() {
		return reqAuthLevel;
	}

	public void setReqAuthLevel(int reqAuthLevel) {
		this.reqAuthLevel = reqAuthLevel;
	}
}
