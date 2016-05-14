package com.se.database.dao.daoImplementation;

import com.se.database.dao.interfaces.IStudentScholarshipDAO;
import com.se.database.dao.model.academic.grants.ScholarshipVO;
import com.se.database.dao.model.academic.grants.StudentScholarshipVO;
import com.se.database.dao.model.users.StudentVO;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public class StudentScholarshipDAOImpl implements IStudentScholarshipDAO {

    /**
     * The session factory from spring
     */
    private SessionFactory sessionFactory;

    public StudentScholarshipDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<StudentScholarshipVO> list() {
        @SuppressWarnings("unchecked")
        List<StudentScholarshipVO> listUser = (List<StudentScholarshipVO>) sessionFactory.getCurrentSession()
                .createCriteria(StudentScholarshipVO.class)
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

        return listUser;
    }

    @Override
    public List<ScholarshipVO> getScholarshipsForStudent(StudentVO studentVO) {
        return null;
    }

    @Override
    public void deleteScholarshipForStudent(int scholarshipId, int studentId) {

    }
    
}
