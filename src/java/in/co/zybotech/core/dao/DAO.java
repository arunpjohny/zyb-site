package in.co.zybotech.core.dao;

import java.io.Serializable;

public interface DAO {
	<T> T getObject(Class<T> clazz, Serializable id);

	<T> T saveObject(T object, Class<T> clazz);

	<T> T remove(Class<T> clazz, Serializable id);
}
