package com.imobiliare.services;

import java.util.List;

public interface CrudService <T> {
	T save (T object);
	List<T> getAll ();
	T getById (Long id);
	void delete (Long id);
}
