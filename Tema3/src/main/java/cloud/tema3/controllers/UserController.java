package cloud.tema3.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cloud.tema3.DTOs.UserDTO;
import cloud.tema3.entities.User;
import cloud.tema3.services.UserService;
import cloud.tema3.transformers.UserTransformer;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/v1/users")
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	UserTransformer userTransformer;
	
	@ApiOperation(value = "Insert a new user.")
	@RequestMapping(method = RequestMethod.POST, consumes="application/json", produces = "application/json")
	public ResponseEntity<UserDTO> post(@RequestBody UserDTO userDto) {
		User user = userTransformer.toModel(userDto);
		
		userService.save(user);
		
		return new ResponseEntity<UserDTO>(userDto, HttpStatus.CREATED);
	}
	
	@ApiOperation(value = "Retrieve a list of all users.")
	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<User>> getAll() {
		List<User> users = userService.getAll();
		
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Retrieve a user by ID.")
	@RequestMapping(method = RequestMethod.GET, value = "/{userId}", produces = "application/json")
	public ResponseEntity<User> getById(@PathVariable("userId") UUID id) {
		User user = userService.getById(id);
		
		return new ResponseEntity<>(user, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Put a user by ID.")
	@RequestMapping(method = RequestMethod.PUT, value = "/{userId}", produces = "application/json")
	public ResponseEntity<User> updateById(@PathVariable("userId") UUID id, @RequestBody UserDTO userDto) {
		User user = userTransformer.toModel(userDto);
		userService.updateById(id, user);
		
		return new ResponseEntity<User>(HttpStatus.OK);
	}
	
	@ApiOperation(value = "Delete a user by ID.")
	@RequestMapping(method = RequestMethod.DELETE, value = "/{userId}", produces = "application/json")
	public ResponseEntity<User> deleteById(@PathVariable("userId") UUID id) {
		userService.delete(id);

		return new ResponseEntity<User>(HttpStatus.OK);
	}
	
}
