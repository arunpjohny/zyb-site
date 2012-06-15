package in.co.zybotech.core.service;

import java.io.Serializable;

public interface Manager {

	<T> T getObject(Class<T> clazz, Serializable id);

}
