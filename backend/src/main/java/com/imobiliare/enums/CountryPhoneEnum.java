package com.imobiliare.enums;

public enum CountryPhoneEnum {
	ROMANIA((byte)10);
	
	private byte phoneNumberLength;
	
	CountryPhoneEnum (byte phoneNumberLength){
		this.phoneNumberLength = phoneNumberLength;
	}

	public byte getPhoneNumberLength() {
		return phoneNumberLength;
	}

	public void setPhoneNumberLength(byte phoneNumberLength) {
		this.phoneNumberLength = phoneNumberLength;
	}
}
