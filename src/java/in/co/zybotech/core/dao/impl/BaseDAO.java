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

}
