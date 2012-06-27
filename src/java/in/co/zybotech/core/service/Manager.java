package in.co.zybotech.core.service;

import in.co.zybotech.model.career.Student;

import java.io.Serializable;

public interface Manager {

	<T> T getObject(Class<T> clazz, Serializable id);

	void saveObject(Object object);

	byte[] getBytes(Class<Student> clazz, Serializable id, String field)
			throws SecurityException, NoSuchFieldException,
			IllegalArgumentException, IllegalAccessException;

}
