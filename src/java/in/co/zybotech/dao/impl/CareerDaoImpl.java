package in.co.zybotech.dao.impl;

import in.co.zybotech.core.dao.impl.BaseDAO;
import in.co.zybotech.dao.CareerDao;
import in.co.zybotech.model.career.CareerStudent;

import java.util.Collection;

import org.springframework.stereotype.Repository;

@Repository
public class CareerDaoImpl extends BaseDAO implements CareerDao {

	@SuppressWarnings("unchecked")
	@Override
	public Collection<CareerStudent> getStudentsForCareer() {
		String criteriaQuery = "from CareerStudent order by weight";
		return entityManager.createQuery(criteriaQuery).getResultList();
	}

}
