package in.co.zybotech.service.impl;

import in.co.zybotech.core.service.impl.BaseManager;
import in.co.zybotech.dao.MiscDao;
import in.co.zybotech.model.zyb.Personnel;
import in.co.zybotech.model.zyb.PersonnelType;
import in.co.zybotech.service.PersonnelManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true, propagation = Propagation.REQUIRED)
public class PersonnelManagerImpl extends BaseManager implements
		PersonnelManager {

	@Autowired
	public PersonnelManagerImpl(MiscDao dao) {
		super();
		setDao(dao);
	}

	@Override
	public PersonnelType getPersonnelType(String type) {
		PersonnelType ptype = getObject(PersonnelType.class, type);
		ptype.getPersonnel().size();
		return ptype;
	}

	@Override
	public Personnel getPersonnel(int id) {
		Personnel object = getObject(Personnel.class, id);
		object.getType().getCaption();
		return object;
	}

}
