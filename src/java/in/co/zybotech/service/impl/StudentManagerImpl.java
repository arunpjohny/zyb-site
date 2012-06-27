package in.co.zybotech.service.impl;

import in.co.zybotech.core.service.impl.BaseManager;
import in.co.zybotech.dao.StudentDao;
import in.co.zybotech.model.career.Student;
import in.co.zybotech.service.StudentManager;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true, propagation = Propagation.REQUIRED)
public class StudentManagerImpl extends BaseManager implements StudentManager {

	protected StudentDao studentDao;

	@Autowired
	public StudentManagerImpl(StudentDao studentDao) {
		super();
		this.studentDao = studentDao;
		setDao(studentDao);
	}

	@Override
	public Collection<Student> getStudents() {
		return studentDao.getStudents();
	}

}
