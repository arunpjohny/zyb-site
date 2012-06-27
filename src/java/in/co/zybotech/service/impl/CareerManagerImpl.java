package in.co.zybotech.service.impl;

import in.co.zybotech.core.service.impl.BaseManager;
import in.co.zybotech.service.CareerManager;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true, propagation = Propagation.REQUIRED)
public class CareerManagerImpl extends BaseManager implements CareerManager {

}
