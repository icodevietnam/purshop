package com.icoding.core.serviceimpl;

import java.io.Serializable;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.icoding.core.dao.IGenericDao;
import com.icoding.core.service.IGenericService;

@Service
@Transactional
public abstract class GenericServiceImpl<E, K> implements IGenericService<E, K> {
	private static Logger LOGGER = LoggerFactory.getLogger(GenericServiceImpl.class);

	abstract IGenericDao<E, K> getDao();

	/**
	 * @param entity
	 */
	public void add(E entity) {
		LOGGER.debug("Generic Service - Save entity " + entity.getClass().getName() + " successfully.");
		getDao().add(entity);
	}

	/**
	 * @param entity
	 */
	public void saveOrUpdate(E entity) {
		LOGGER.debug("Generic Service - Save or update entity " + entity.getClass().getName() + " successfully.");
		getDao().saveOrUpdate(entity);
	}

	/**
	 * @param entity
	 * @return
	 */
	public Boolean saveOrUpdateEntity(E entity) {
		LOGGER.debug("Generic Service - Save or update entity " + entity.getClass().getName() + " successfully.");
		return getDao().saveOrUpdateEntity(entity);
	}

	/**
	 * @param entity
	 */
	public void remove(E entity) {
		LOGGER.debug("Generic Service - Remove entity " + entity.getClass().getName() + " successfully.");
		getDao().remove(entity);
	}

	/**
	 * @param entity
	 * @return
	 */
	public Boolean removeEntity(E entity) {
		LOGGER.debug("Generic Service - Remove entity " + entity.getClass().getName() + " successfully.");
		return getDao().removeEntity(entity);
	}

	/**
	 * @param key
	 * @return
	 */
	public E find(K key) {
		LOGGER.debug("Generic Service - Get entity with id: " + key + " successfully.");
		return getDao().find(key);
	}

	/**
	 * @return
	 */
	public List<E> getAll() {
		LOGGER.debug("Generic Service - Get List successfully.");
		return getDao().getAll();
	}

	/**
	 * @param entity
	 */
	public void update(E entity) {
		LOGGER.debug("Generic Service - Update entity " + entity.getClass().getName() + " successfully.");
		getDao().update(entity);
	}

	/**
	 * @param entity
	 */
	public Serializable addAndGetId(E entity) {
		LOGGER.debug("Generic Service - Save entity " + entity.getClass().getName() + " successfully and return id");
		return getDao().addAndGetId(entity);
	}
}
