package cloud.imobiliare.enums;

import javax.management.relation.InvalidRoleInfoException;

public enum UserRoles {
	USER((byte)1), ADMIN((byte)5);
	
	private byte rightsLevel;
	
	UserRoles (byte rightsLevel){
		this.rightsLevel = rightsLevel;
	}

	public byte getRightsLevel() {
		return rightsLevel;
	}

	public void setRightsLevel(byte rightsLevel) {
		this.rightsLevel = rightsLevel;
	}
	
	public static UserRoles toEnum(String role) throws InvalidRoleInfoException{
		switch(role){
		case "user": return USER;
		case "admin": return ADMIN;
		default: throw new InvalidRoleInfoException();
		}
	}
}
