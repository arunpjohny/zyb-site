package in.co.zybotech.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.co.zybotech.core.service.impl.BaseManager;
import in.co.zybotech.dao.ProductAndServicesDao;
import in.co.zybotech.service.ProductAndServicesManager;

@Service("productAndServicesManager")
public class ProductAndServicesManagerImpl extends BaseManager implements
		ProductAndServicesManager {
	private ProductAndServicesDao productAndServicesDao;

	@Autowired
	public ProductAndServicesManagerImpl(
			ProductAndServicesDao productAndServicesDao) {
		super();
		setDao(productAndServicesDao);
		this.productAndServicesDao = productAndServicesDao;
	}

}
