package in.co.zybotech.dao.impl;

import in.co.zybotech.core.dao.impl.BaseDAO;
import in.co.zybotech.dao.MiscDao;
import in.co.zybotech.model.misc.EBroucher;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class MiscDaoImpl extends BaseDAO implements MiscDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<EBroucher> getBrouchers() {
		return entityManager.createQuery("from EBroucher b order by b.order")
				.getResultList();
	}

}
