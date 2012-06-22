package in.co.zybotech.service.impl;

import in.co.zybotech.core.service.impl.BaseManager;
import in.co.zybotech.dao.PlacementDao;
import in.co.zybotech.model.placement.PlacementOpening;
import in.co.zybotech.service.PlacementManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true, propagation = Propagation.REQUIRED)
public class PlacementManagerImpl extends BaseManager implements
		PlacementManager {

	protected PlacementDao placementDao;

	@Autowired
	public PlacementManagerImpl(PlacementDao placementDao) {
		super();
		this.placementDao = placementDao;
		setDao(placementDao);
	}

	@Override
	public Integer getNextOpeningId(int opening) {
		return placementDao.getNextOpeningId(opening);
	}

	@Override
	public Integer getPreviousOpeningId(int opening) {
		return placementDao.getPreviousOpeningId(opening);
	}

	@Override
	public PlacementOpening getLatestOpening() {
		return placementDao.getLatestOpening();
	}

}
