package com.se.database.dao.daoImplementation;

import com.se.database.dao.interfaces.IProfessorDAO;
import com.se.database.dao.model.users.ProfessorVO;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class ProfessorDAOImpl implements IProfessorDAO {
    /**
     * The session factory from spring
     */
    private SessionFactory sessionFactory;

    public ProfessorDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional
    public List<ProfessorVO> list() {
        @SuppressWarnings("unchecked")
        List<ProfessorVO> listUser = (List<ProfessorVO>) sessionFactory.getCurrentSession()
                .createCriteria(ProfessorVO.class)
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

        return listUser;
    }
}
