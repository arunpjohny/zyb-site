package in.co.zybotech.core.dao.impl;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import in.co.zybotech.core.dao.DAO;

public class BaseDAO implements DAO {

	@PersistenceContext
	protected EntityManager entityManager;

	@Override
	public <T> T getObject(Class<T> clazz, Serializable id) {
		return entityManager.find(clazz, id);
	}

	@Override
	public <T> T saveObject(T object, Class<T> clazz) {
		return entityManager.merge(object);
	}

	@Override
	public <T> T remove(Class<T> clazz, Serializable id) {
		T object = getObject(clazz, id);
		entityManager.remove(object);
		return object;
	}

}
