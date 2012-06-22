package in.co.zybotech.dao;

import in.co.zybotech.core.dao.DAO;
import in.co.zybotech.model.placement.PlacementOpening;

public interface PlacementDao extends DAO {

	Integer getNextOpeningId(int opening);

	Integer getPreviousOpeningId(int opening);

	PlacementOpening getLatestOpening();

}
