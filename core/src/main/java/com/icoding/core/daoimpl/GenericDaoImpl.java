package com.icoding.core.daoimpl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.icoding.core.dao.IGenericDao;

@Repository
@Transactional
public abstract class GenericDaoImpl<E, K extends Serializable> implements IGenericDao<E, K> {
	private static Logger LOGGER = LoggerFactory.getLogger(GenericDaoImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	protected Class<? extends E> daoType;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public GenericDaoImpl() {
		LOGGER.debug("Init Generic Dao - Implement Abstract Facade Into The System");
		Type t = getClass().getGenericSuperclass();
		ParameterizedType pt = (ParameterizedType) t;
		daoType = (Class) pt.getActualTypeArguments()[0];
	}

	/**
	 * @return current session from hibernate. Obtains the current session
	 */
	public Session currentSession() {
		LOGGER.debug("Generic Dao - Get Current Session.");
		return sessionFactory.getCurrentSession();
	}

	/**
	 * @param entity
	 *            Save all entity into database
	 */
	public void add(E entity) {
		LOGGER.debug("Generic Dao - Save entity " + entity.getClass().getName() + " successfully.");
		currentSession().save(entity);
	}

	/**
	 * @param entity
	 *            Save all and update entity into database
	 */
	public void saveOrUpdate(E entity) {
		LOGGER.debug("Generic Dao - Save or update entity " + entity.getClass().getName() + " successfully.");
		currentSession().saveOrUpdate(entity);
	}

	/**
	 * @param entity
	 *            Only update entity into the database
	 */
	public void update(E entity) {
		LOGGER.debug("Generic Dao - Update entity " + entity.getClass().getName() + " successfully.");
		currentSession().update(entity);
	}

	/**
	 * @param entity
	 *            Remove the entity out of database
	 */
	public void remove(E entity) {
		LOGGER.debug("Generic Dao - Remove entity " + entity.getClass().getName() + " successfully.");
		currentSession().delete(entity);
	}

	/**
	 * @param key
	 *            - Id of the entity
	 * @return Object of the entity For example : Person, Dog, Bird ...
	 */
	public E find(K key) {
		LOGGER.debug("Generic Dao - Get entity with id: " + key + " successfully.");
		return (E) currentSession().get(daoType, key);
	}

	/**
	 * @return List of Object In the database
	 */
	public List<E> getAll() {
		LOGGER.debug("Generic Dao - Get List successfully.");
		return currentSession().createCriteria(daoType).list();
	}

	/**
	 * @param entity
	 * @return status when we save or update success or fail
	 */
	public Boolean saveOrUpdateEntity(E entity) {
		Boolean isSuccess = false;
		try {
			LOGGER.debug("Generic Dao - Save or update entity " + entity.getClass().getName() + " successfully.");
			currentSession().saveOrUpdate(entity);
			isSuccess = true;
		} catch (Exception e) {
			e.printStackTrace();
			isSuccess = false;
		}
		return isSuccess;
	}

	/**
	 * @param entity
	 * @return status when we delete success or fail
	 */
	public Boolean removeEntity(E entity) {
		Boolean isSuccess = false;
		try {
			LOGGER.debug("Generic Dao - Remove entity " + entity.getClass().getName() + " successfully.");
			currentSession().delete(entity);
			isSuccess = true;
		} catch (Exception e) {
			e.printStackTrace();
			isSuccess = false;
		}
		return isSuccess;
	}

	public Serializable addAndGetId(E entity) {
		Serializable result = 0;
		try {
			LOGGER.debug("Generic Dao - Save entity " + entity.getClass().getName() + " successfully and return id");
			result = currentSession().save(entity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
