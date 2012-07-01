package in.co.zybotech.service.impl;

import java.util.List;

import in.co.zybotech.core.service.impl.BaseManager;
import in.co.zybotech.dao.MiscDao;
import in.co.zybotech.model.misc.EBroucher;
import in.co.zybotech.service.MiscManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true, propagation = Propagation.REQUIRED)
public class MiscManagerImpl extends BaseManager implements MiscManager {
	private MiscDao miscDao;

	@Autowired
	public MiscManagerImpl(MiscDao miscDao) {
		super();
		setDao(miscDao);
		this.miscDao = miscDao;
	}

	@Override
	public List<EBroucher> getBrouchers() {
		return miscDao.getBrouchers();
	}

}
