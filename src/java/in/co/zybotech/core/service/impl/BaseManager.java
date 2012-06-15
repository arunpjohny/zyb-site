package in.co.zybotech.core.service.impl;

import java.io.Serializable;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import in.co.zybotech.core.dao.DAO;
import in.co.zybotech.core.service.Manager;

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

}
