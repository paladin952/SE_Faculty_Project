package com.se.database.dao.daoImplementation;

import com.se.database.dao.interfaces.IUserDAO;
import com.se.database.dao.model.users.PersonVO;
import com.se.database.dao.model.users.UserVO;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Clapa Lucian on 4/3/2016.
 */
public class UserDAOImpl implements IUserDAO {
    /**
     * The session factory from spring
     */
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

    @Transactional
    public UserVO getById(int id) {
        return (UserVO)sessionFactory.getCurrentSession()
                .get(UserVO.class, id);
    }

    @Transactional
    public void deleteById(int id) {
        UserVO user = (UserVO)sessionFactory.getCurrentSession().get(UserVO.class, id);
        sessionFactory.getCurrentSession().delete(user);
    }

    @Transactional
    public UserVO updateUser(UserVO newUser) {
        Session session = sessionFactory.getCurrentSession();
        UserVO user = (UserVO)session.load(UserVO.class, newUser.getId());
        if (user == null)
        {
            UserVO tmp = new UserVO(newUser.getUsername(), newUser.getPassword());
            session.save(tmp);
            return tmp;
        }
        else
        {
            user.setPassword(newUser.getPassword());
            user.setUsername(newUser.getUsername());
            return user;
        }
    }
}
