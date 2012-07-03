package in.co.zybotech.core.service;

import in.co.zybotech.core.dao.criteria.SearchCriteria;
import in.co.zybotech.core.dao.criteria.SearchCriteriaResult;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface Manager {

	<T> T getObject(Class<T> clazz, Serializable id);

	<T> T saveObject(T object, Class<T> clazz);

	<T> T remove(Class<T> clazz, Serializable id);

	<T> byte[] getBytes(Class<T> clazz, Serializable id, String field)
			throws SecurityException, NoSuchFieldException,
			IllegalArgumentException, IllegalAccessException;

	<T> List<T> query(SearchCriteria criteria, Class<T> clazz);

	List<Map<String, Object>> query(SearchCriteria criteria);

	long getCount(SearchCriteria criteria);

	<T> SearchCriteriaResult<T> queryResult(SearchCriteria criteria,
			Class<T> clazz);
}
