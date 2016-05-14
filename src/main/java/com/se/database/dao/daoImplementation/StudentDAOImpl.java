package com.se.database.dao.daoImplementation;

import com.se.database.dao.interfaces.IStudentDAO;
import com.se.database.dao.model.users.StudentVO;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public class StudentDAOImpl implements IStudentDAO {
    /**
     * The session factory from spring
     */
    private SessionFactory sessionFactory;

    public StudentDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional
    public List<StudentVO> list() {
        @SuppressWarnings("unchecked")
        List<StudentVO> listUser = (List<StudentVO>) sessionFactory.getCurrentSession()
                .createCriteria(StudentVO.class)
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

        return listUser;
    }
}
