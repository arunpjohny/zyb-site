package in.co.zybotech.core.service.impl;

import in.co.zybotech.core.dao.DAO;
import in.co.zybotech.core.exception.client.ResourceNotFoundException;
import in.co.zybotech.core.service.Manager;
import in.co.zybotech.model.career.Student;

import java.io.Serializable;
import java.lang.reflect.Field;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ReflectionUtils;

@Transactional(readOnly = true, propagation = Propagation.REQUIRED)
public class BaseManager implements Manager {

	protected DAO dao;

	public void setDao(DAO dao) {
		this.dao = dao;
	}

	@Override
	public <T> T getObject(Class<T> clazz, Serializable id) {
		return dao.getObject(clazz, id);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public <T> T saveObject(T object, Class<T> clazz) {
		return dao.saveObject(object, clazz);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public <T> T remove(Class<T> clazz, Serializable id) {
		return dao.remove(clazz, id);
	}

	@Override
	public <T> byte[] getBytes(Class<T> clazz, Serializable id, String field)
			throws SecurityException, NoSuchFieldException,
			IllegalArgumentException, IllegalAccessException {
		T object = getObject(clazz, id);
		if (object == null) {
			throw new ResourceNotFoundException("Unable to find the resource "
					+ clazz + " with id " + id + ".");
		}
		Field f = ReflectionUtils.findField(clazz, field);
		if (f == null) {
			throw new ResourceNotFoundException("Unable to find field" + f
					+ " from " + clazz + ".");
		}
		f.setAccessible(true);
		return (byte[]) f.get(object);
	}

}
