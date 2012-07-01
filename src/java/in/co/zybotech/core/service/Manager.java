package in.co.zybotech.core.service;

import in.co.zybotech.model.career.Student;

import java.io.Serializable;

public interface Manager {

	<T> T getObject(Class<T> clazz, Serializable id);

	<T> T saveObject(T object, Class<T> clazz);

	<T> T remove(Class<T> clazz, Serializable id);

	byte[] getBytes(Class<Student> clazz, Serializable id, String field)
			throws SecurityException, NoSuchFieldException,
			IllegalArgumentException, IllegalAccessException;

}
