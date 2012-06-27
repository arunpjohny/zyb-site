package in.co.zybotech.dao;

import java.util.Collection;

import in.co.zybotech.core.dao.DAO;
import in.co.zybotech.model.career.Student;

public interface StudentDao extends DAO {

	Collection<Student> getStudents();

}
