package cloud.imobiliare.services;

import org.apache.http.auth.InvalidCredentialsException;

import cloud.imobiliare.entities.User;
import cloud.imobiliare.services.common.CrudService;

public interface UserService extends CrudService<User, Long> {
	void updateFirstName(long id, String firstName);
	void updateLastName(long id, String lastName);
	void updateEmail(long id, String email);
	void updatePhoneNumber(long id, String phoneNumber);
	User getByEmail (String email);
	void validateCredentials (String email, String password) throws InvalidCredentialsException;
	String getRole (String email);
	Long getId (String email);
}
