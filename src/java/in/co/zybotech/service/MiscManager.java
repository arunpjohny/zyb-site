package in.co.zybotech.service;

import in.co.zybotech.core.service.Manager;
import in.co.zybotech.model.misc.EBroucher;

import java.util.List;

public interface MiscManager extends Manager {

	List<EBroucher> getBrouchers();

}
