package in.co.zybotech.service;

import in.co.zybotech.core.service.Manager;
import in.co.zybotech.model.placement.PlacementOpening;

public interface PlacementManager extends Manager {

	Integer getNextOpeningId(int opening);

	Integer getPreviousOpeningId(int opening);

	PlacementOpening getLatestOpening();

}
