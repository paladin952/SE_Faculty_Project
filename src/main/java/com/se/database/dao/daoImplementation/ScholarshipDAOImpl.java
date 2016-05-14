package com.se.database.dao.daoImplementation;

import com.se.database.dao.interfaces.IScholarshipDAO;
import com.se.database.dao.model.academic.grants.ScholarshipVO;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public class ScholarshipDAOImpl implements IScholarshipDAO {
    /**
     * The session factory from spring
     */
    private SessionFactory sessionFactory;

    public ScholarshipDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<ScholarshipVO> list() {
        @SuppressWarnings("unchecked")
        List<ScholarshipVO> listUser = (List<ScholarshipVO>) sessionFactory.getCurrentSession()
                .createCriteria(ScholarshipVO.class)
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
        return listUser;
    }

    @Override
    public ScholarshipVO getById(int id) {
        return null;
    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public ScholarshipVO updateUser(ScholarshipVO newScolarship) {
        return null;
    }
}
