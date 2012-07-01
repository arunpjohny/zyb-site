package in.co.zybotech.core.service;

import java.io.Serializable;

public interface Manager {

	<T> T getObject(Class<T> clazz, Serializable id);

	<T> T saveObject(T object, Class<T> clazz);

	<T> T remove(Class<T> clazz, Serializable id);

	<T> byte[] getBytes(Class<T> clazz, Serializable id, String field)
			throws SecurityException, NoSuchFieldException,
			IllegalArgumentException, IllegalAccessException;

}
