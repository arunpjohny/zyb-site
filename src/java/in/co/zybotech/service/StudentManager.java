package in.co.zybotech.service;

import in.co.zybotech.core.service.Manager;
import in.co.zybotech.model.career.Student;

import java.util.Collection;

public interface StudentManager extends Manager {

	Collection<Student> getStudents();

}
