package cloud.imobiliare.security;

public class JWebTokenUser {
	private long id;
	private String email;
	private String role;

	public JWebTokenUser() {
	}
	
	public JWebTokenUser(String id, String userName, String role) {
		this.id = Long.valueOf(id);
		this.email = userName;
		this.role = role;
	}

	public String getUserName() {
		return email;
	}

	public String getRole() {
		return role;
	}

	public void setUserName(String userName) {
		this.email = userName;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

}
