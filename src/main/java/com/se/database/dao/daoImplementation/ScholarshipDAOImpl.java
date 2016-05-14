package com.se.database.dao.daoImplementation;

import com.se.database.dao.interfaces.IScholarshipDAO;
import com.se.database.dao.model.academic.grants.ScholarshipVO;
import org.hibernate.Criteria;
import org.hibernate.Session;
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
        return (ScholarshipVO) sessionFactory.getCurrentSession()
                .get(ScholarshipVO.class, id);
    }

    @Override
    public void deleteById(int id) {
        ScholarshipVO user = (ScholarshipVO) sessionFactory.getCurrentSession().get(ScholarshipVO.class, id);
        sessionFactory.getCurrentSession().delete(user);
    }

    @Override
    public ScholarshipVO updateScholarship(ScholarshipVO newScholarship) {
        Session session = sessionFactory.getCurrentSession();
        ScholarshipVO exists = (ScholarshipVO) session.get(ScholarshipVO.class, newScholarship.getId());
        if (exists != null) {
            ScholarshipVO update = (ScholarshipVO) session.load(ScholarshipVO.class, newScholarship.getId());

            update.setName(newScholarship.getName());
            update.setSum(newScholarship.getSum());

            return update;

        } else {
            ScholarshipVO tmp = new ScholarshipVO(newScholarship.getId(), newScholarship.getName(), newScholarship.getSum());
            session.save(tmp);
            return tmp;
        }
    }
}
