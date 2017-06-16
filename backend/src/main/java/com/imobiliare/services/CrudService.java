package com.imobiliare.services;

import java.util.List;

public interface CrudService <T, T2> {
	void save (T object);
	List<T> getAll ();
	T getById (T2 id);
	void delete (T2 id);
}
