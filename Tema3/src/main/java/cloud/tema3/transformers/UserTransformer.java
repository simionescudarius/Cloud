package cloud.tema3.transformers;

import java.util.UUID;

import org.springframework.stereotype.Component;

import cloud.tema3.DTOs.UserDTO;
import cloud.tema3.entities.User;

@Component
public class UserTransformer implements Transformer<User, UserDTO> {

	@Override
	public UserDTO toDTO(User object) {
		UserDTO userDTO = new UserDTO();
		
		userDTO.setEmail(object.getEmail());
		userDTO.setFirstName(object.getFirstName());
		userDTO.setLastName(object.getLastName());
		userDTO.setPassword(object.getPassword());
		userDTO.setPhoneNumber(object.getPhoneNumber());
		
		return userDTO;
	}

	@Override
	public User toModel(UserDTO object) {
		User user = new User();
		
		user.setId(UUID.randomUUID());
		user.setEmail(object.getEmail());
		user.setFirstName(object.getFirstName());
		user.setLastName(object.getLastName());
		user.setPassword(object.getPassword());
		user.setPhoneNumber(object.getPhoneNumber());
		
		return user;
	}

}
