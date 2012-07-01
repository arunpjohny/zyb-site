package in.co.zybotech.dao.impl;

import javax.persistence.NoResultException;

import in.co.zybotech.core.dao.impl.BaseDAO;
import in.co.zybotech.dao.PlacementDao;
import in.co.zybotech.model.placement.PlacementOpening;

import org.springframework.stereotype.Repository;

@Repository
public class PlacementDaoImpl extends BaseDAO implements PlacementDao {

	@Override
	public Integer getNextOpeningId(int opening) {
		String criteriaQuery = "select min(id) from PlacementOpening o"
				+ " where o.id > (select id from PlacementOpening where id = :id)";
		return (Integer) entityManager.createQuery(criteriaQuery)
				.setParameter("id", opening).getSingleResult();
	}

	@Override
	public Integer getPreviousOpeningId(int opening) {
		String criteriaQuery = "select max(id) from PlacementOpening o"
				+ " where o.id < (select id from PlacementOpening where id = :id)";
		return (Integer) entityManager.createQuery(criteriaQuery)
				.setParameter("id", opening).getSingleResult();
	}

	@Override
	public PlacementOpening getLatestOpening() {
		String criteriaQuery = "from PlacementOpening where id = (select max(id) from PlacementOpening)";
		PlacementOpening singleResult = null;
		try {
			singleResult = (PlacementOpening) entityManager.createQuery(
					criteriaQuery).getSingleResult();
		} catch (NoResultException e) {
			// Ignore
		}
		return singleResult;
	}

}
