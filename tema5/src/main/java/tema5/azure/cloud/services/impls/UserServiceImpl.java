package tema5.azure.cloud.services.impls;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tema5.azure.cloud.dao.UserRepository;
import tema5.azure.cloud.entities.User;
import tema5.azure.cloud.services.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void save(User object) {
		userRepository.save(object);
	}

	@Override
	public List<User> getAll() {
		return (List<User>) userRepository.findAll();
	}

	@Override
	public Optional<User> getById(String id) {
		return userRepository.findById(id);
	}
	
	@Override
	public User updateById(String id, User entity) {
		userRepository.deleteById(id);
		
		entity.setId(id);
		userRepository.save(entity);
		
		return entity;
	}

	@Override
	public void delete(String id) {
		userRepository.deleteById(id);
	}

}
