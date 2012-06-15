package in.co.zybotech.service;

import in.co.zybotech.core.service.Manager;
import in.co.zybotech.model.career.CareerStudent;

import java.io.Serializable;
import java.util.Collection;

public interface CareerManager extends Manager {

	Collection<CareerStudent> getStudentsForCareer();

}
