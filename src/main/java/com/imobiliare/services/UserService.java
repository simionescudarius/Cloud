package com.imobiliare.services;

import com.imobiliare.models.User;

public interface UserService extends CrudService<User> {
	void updateFirstName(long id, String name);
}
