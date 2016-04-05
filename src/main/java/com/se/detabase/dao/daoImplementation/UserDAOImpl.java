package com.se.detabase.dao.daoImplementation;

import java.util.List;

import com.se.detabase.dao.interfaces.UserDAO;
import com.se.detabase.dao.model.users.UserVO;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;
/**
 * Created by Clapa Lucian on 4/3/2016.
 */
public class UserDAOImpl implements UserDAO {
    private SessionFactory sessionFactory;

    public UserDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional
    public List<UserVO> list() {
        @SuppressWarnings("unchecked")
        List<UserVO> listUser = (List<UserVO>) sessionFactory.getCurrentSession()
                .createCriteria(UserVO.class)
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

        return listUser;
    }
}
