package com.imobiliare.controllers;

import org.apache.http.auth.InvalidCredentialsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.imobiliare.DTOs.AuthDTO;
import com.imobiliare.DTOs.UserDTO;
import com.imobiliare.security.JwtService;
import com.imobiliare.security.JwtUser;
import com.imobiliare.services.UserService;
import com.imobiliare.transformers.UserTransformer;
import com.imobiliare.validators.UserValidator;

@CrossOrigin
@RestController
@RequestMapping("/v1/auth")
public class LoginController {
	@Autowired
	private UserService userService;

	@Autowired
	private UserTransformer userTransformer;

	@Autowired
	private UserValidator userValidator;

	@Autowired
	private JwtService jwtService;

	@RequestMapping(method = RequestMethod.POST, value = "/login")
	public ResponseEntity<?> auth(@RequestBody AuthDTO auth) {
		try {
			userService.validateCredentials(auth.getUsername(), auth.getPassword());
		} catch (IllegalArgumentException exception) {
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		} catch (InvalidCredentialsException exception) {
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}
		String email = auth.getUsername();
		JwtUser jwtUser = new JwtUser(userService.getId(email).toString(), email, userService.getRole(email));
		return new ResponseEntity<>(jwtService.getToken(jwtUser), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/verify")
	public ResponseEntity<?> verify() {
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/register")
	public ResponseEntity<?> save(@RequestBody UserDTO userDto, BindingResult validationResult) {
		userValidator.validate(userDto, validationResult);
		if (validationResult.hasErrors()) {
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}
		if (userService.getByEmail(userDto.getEmail()) != null) {
			return new ResponseEntity<>(HttpStatus.IM_USED);
		}
		userService.save(userTransformer.toModel(userDto));
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
}