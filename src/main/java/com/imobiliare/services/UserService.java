package com.imobiliare.services;

import com.imobiliare.models.User;

public interface UserService extends CrudService<User> {
	void updateFirstName(long id, String firstName);
	void updateLastName(long id, String lastName);
	void updateEmail(long id, String email);
	void updatePhoneNumber(long id, String phoneNumber);
	User getByEmail (String email);
}
