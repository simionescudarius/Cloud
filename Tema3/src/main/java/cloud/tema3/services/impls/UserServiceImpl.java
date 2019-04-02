package cloud.tema3.services.impls;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cloud.tema3.entities.User;
import cloud.tema3.repositories.UserRepository;
import cloud.tema3.services.UserService;

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
		return userRepository.findAll();
	}

	@Override
	public User getById(UUID id) {
		return userRepository.getOne(id);
	}
	
	@Override
	public User updateById(UUID id, User entity) {
		userRepository.deleteById(id);
		
		entity.setId(id);
		userRepository.save(entity);
		
		return entity;
	}

	@Override
	public void delete(UUID id) {
		userRepository.deleteById(id);
	}

}
