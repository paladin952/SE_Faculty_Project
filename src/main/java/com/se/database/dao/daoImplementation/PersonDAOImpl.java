package com.se.database.dao.daoImplementation;

import com.se.database.dao.interfaces.IPersonDAO;
import com.se.database.dao.model.users.PersonVO;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Clapa Lucian on 4/5/2016.
 */
public class PersonDAOImpl implements IPersonDAO {
    /**
     * The session factory from spring
     */
    private SessionFactory sessionFactory;

    public PersonDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional
    public List<PersonVO> list() {
        @SuppressWarnings("unchecked")
        List<PersonVO> listUser = (List<PersonVO>) sessionFactory.getCurrentSession()
                .createCriteria(PersonVO.class)
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

        return listUser;
    }
}
