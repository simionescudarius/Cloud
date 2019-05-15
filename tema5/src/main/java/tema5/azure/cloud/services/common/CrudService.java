package tema5.azure.cloud.services.common;

import java.util.List;
import java.util.Optional;

import tema5.azure.cloud.entities.User;

public interface CrudService <T, T2> {
	void save (T object);
	List<T> getAll ();
	Optional<User> getById (T2 id);
	T updateById (T2 id, T entity);
	void delete (T2 id);
}
