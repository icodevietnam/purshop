package com.icoding.core.service;

import java.io.Serializable;
import java.util.List;

public interface IGenericService<E, K> {
	void add(E entity);

	void saveOrUpdate(E entity);

	Boolean saveOrUpdateEntity(E entity);

	void remove(E entity);

	Boolean removeEntity(E entity);

	E find(K key);

	List<E> getAll();

	void update(E entity);

	Serializable addAndGetId(E entity);
}
