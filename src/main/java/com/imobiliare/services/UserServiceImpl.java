package com.imobiliare.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imobiliare.enums.CountryPhoneEnum;
import com.imobiliare.models.User;
import com.imobiliare.repositories.UserRepository;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	@Autowired
	UserRepository userRepository;

	@Override
	public void save(User object) {
		validateData(object.getFirstName(), object.getLastName());
		validateEmail(object.getEmail());
		validatePhoneNumber(object.getPhoneNumber());
		userRepository.save(object);
	}

	@Override
	public List<User> getAll() {
		return userRepository.findAll();
	}

	@Override
	public User getById(Long id) {
		return userRepository.getOne(id);
	}

	@Override
	public void delete(Long id) {
		userRepository.delete(id);
	}

	@Override
	public User getByEmail(String email) {
		validateEmail(email);
		return userRepository.findByEmail(email);
	}

	@Override
	public void updateFirstName(long id, String firstName) {
		validateData(firstName);
		userRepository.updateFirstName(id, firstName);
	}

	@Override
	public void updateLastName(long id, String lastName) {
		validateData(lastName);
		userRepository.updateLastName(id, lastName);
	}

	@Override
	public void updateEmail(long id, String email) {
		validateEmail(email);
		userRepository.updateEmail(id, email);
	}

	@Override
	public void updatePhoneNumber(long id, String phoneNumber) {
		validatePhoneNumber(phoneNumber);
		userRepository.updatePhoneNumber(id, phoneNumber);
	}

	private void validatePhoneNumber(String phoneNumber) {
		if (!phoneNumber.matches("[0-9]+") || phoneNumber.length() != CountryPhoneEnum.ROMANIA.getPhoneNumberLength()) {
			throw new IllegalArgumentException("Invalid phone number !");
		}
	}
	
	private void validateEmail(String email){
		if (!email.matches("[a-zA-Z0-9]+@[a-zA-Z]+.[a-zA-Z]+")) {
			throw new IllegalArgumentException("Invalid email !");
		}
	}

	private void validateData(String ... data) {
		for (String string : data) {
			if (!string.matches("[a-zA-Z]+")) {
				throw new IllegalArgumentException("Invalid data !");
			}
		}
	}
}
