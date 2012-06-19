package in.co.zybotech.service;

import in.co.zybotech.core.service.Manager;
import in.co.zybotech.model.zyb.PersonnelType;

public interface PersonnelManager extends Manager {

	PersonnelType getPersonnelType(String type);

}
