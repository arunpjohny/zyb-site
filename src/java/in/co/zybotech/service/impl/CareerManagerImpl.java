package in.co.zybotech.service.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import in.co.zybotech.core.service.impl.BaseManager;
import in.co.zybotech.dao.CareerDao;
import in.co.zybotech.model.career.CareerStudent;
import in.co.zybotech.service.CareerManager;

@Service
@Transactional(readOnly = true, propagation = Propagation.REQUIRED)
public class CareerManagerImpl extends BaseManager implements CareerManager {

	protected CareerDao careerDao;

	@Autowired
	public CareerManagerImpl(CareerDao careerDao) {
		super();
		this.careerDao = careerDao;
		setDao(careerDao);
	}

	@Override
	public Collection<CareerStudent> getStudentsForCareer() {
		return careerDao.getStudentsForCareer();
	}

}
