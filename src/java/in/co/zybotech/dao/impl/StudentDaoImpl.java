package in.co.zybotech.dao.impl;

import in.co.zybotech.core.dao.impl.BaseDAO;
import in.co.zybotech.dao.StudentDao;
import in.co.zybotech.model.career.Student;

import java.util.Collection;

import org.springframework.stereotype.Repository;

@Repository
public class StudentDaoImpl extends BaseDAO implements StudentDao {

	@SuppressWarnings("unchecked")
	@Override
	public Collection<Student> getStudents() {
		String criteriaQuery = "from Student order by weight, id desc";
		return entityManager.createQuery(criteriaQuery).getResultList();
	}

}
