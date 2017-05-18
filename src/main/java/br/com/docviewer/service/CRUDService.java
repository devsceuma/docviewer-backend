package br.com.docviewer.service;

import java.io.Serializable;

public interface CRUDService<T> {

	T save (T entity);
	T getById(Serializable id);
	Iterable<T> getAll();
	void delete(T id);
}
