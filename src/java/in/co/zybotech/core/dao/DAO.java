package in.co.zybotech.core.dao;

import java.io.Serializable;

public interface DAO {
	<T> T getObject(Class<T> clazz, Serializable id);

	void saveObject(Object object);
}
