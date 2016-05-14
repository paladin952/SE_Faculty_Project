package com.se.database.dao.daoImplementation;

import com.se.database.dao.interfaces.IStudentScholarshipDAO;
import com.se.database.dao.model.academic.grants.StudentScholarshipVO;
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
    public StudentScholarshipVO getById(int id) {
        return null;
    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public StudentScholarshipVO updateUser(StudentScholarshipVO newUser) {
        return null;
    }
}
