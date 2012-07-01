package in.co.zybotech.dao;

import in.co.zybotech.core.dao.DAO;
import in.co.zybotech.model.misc.EBroucher;

import java.util.List;

public interface MiscDao extends DAO {

	List<EBroucher> getBrouchers();

}
