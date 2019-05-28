package cloud.imobiliare.services.impls;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.apache.http.auth.InvalidCredentialsException;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cloud.imobiliare.entities.User;
import cloud.imobiliare.repositories.UserRepository;
import cloud.imobiliare.services.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;

	@Override
	public void save(User object) {
		String encryptedPassword = BCrypt.hashpw(object.getPassword(), BCrypt.gensalt());
		object.setPassword(encryptedPassword);
		userRepository.save(object);
	}

	@Override
	public List<User> getAll() {
		return userRepository.findAll();
	}

	@Override
	public User getById(Long id) {
		Optional<User> user = userRepository.findById(id);

		if (user.isPresent()) {
			return user.get();
		}

		return null;
	}

	@Override
	public void delete(Long id) {
		userRepository.deleteById(id);
	}

	@Override
	public User getByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	@Override
	public void updateFirstName(long id, String firstName) {
		userRepository.updateFirstName(id, firstName);
	}

	@Override
	public void updateLastName(long id, String lastName) {
		userRepository.updateLastName(id, lastName);
	}

	@Override
	public void updateEmail(long id, String email) {
		userRepository.updateEmail(id, email);
	}

	@Override
	public void updatePhoneNumber(long id, String phoneNumber) {
		userRepository.updatePhoneNumber(id, phoneNumber);
	}

	@Override
	public void validateCredentials(String email, String password) throws InvalidCredentialsException {
		String encryptedPassword = userRepository.getPassword(email);
		if (encryptedPassword == null || !BCrypt.checkpw(password, encryptedPassword)) {
			throw new InvalidCredentialsException();
		}
	}

	@Override
	public String getRole(String email) {
		return userRepository.getRole(email);
	}

	@Override
	public Long getId(String email) {
		return Long.valueOf(userRepository.getId(email));
	}
}
