package cloud.tema3.services.common;

import java.util.List;

public interface CrudService <T, T2> {
	void save (T object);
	List<T> getAll ();
	T getById (T2 id);
	T updateById (T2 id, T entity);
	void delete (T2 id);
}
