package com.imobiliare.controllers;

import org.apache.http.auth.InvalidCredentialsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.imobiliare.DTOs.AuthDTO;
import com.imobiliare.security.JwtService;
import com.imobiliare.security.JwtUser;
import com.imobiliare.services.UserService;

@RestController
@RequestMapping("/v1")
public class LoginController {
	@Autowired
	private UserService userService;

	@Autowired
	private JwtService jwtService;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<?> auth(@RequestBody AuthDTO auth) {
		try {
			userService.validateCredentials(auth.getUsername(), auth.getPassword());
		}catch(IllegalArgumentException exception){
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}catch (InvalidCredentialsException exception) {
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}
		String email = auth.getUsername();
		JwtUser jwtUser = new JwtUser(userService.getId(email).toString(), email, userService.getRole(email));
		return new ResponseEntity<>(jwtService.getToken(jwtUser), HttpStatus.OK);
	}
}