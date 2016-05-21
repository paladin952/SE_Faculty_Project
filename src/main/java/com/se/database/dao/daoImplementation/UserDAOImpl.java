package com.se.database.dao.daoImplementation;

import com.se.database.dao.interfaces.IUserDAO;
import com.se.database.dao.model.users.AdminVO;
import com.se.database.dao.model.users.PersonVO;
import com.se.database.dao.model.users.UserVO;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Clapa Lucian on 4/3/2016.
 */
@Transactional
public class UserDAOImpl implements IUserDAO {
    /**
     * The session factory from spring
     */
    private SessionFactory sessionFactory;

    public UserDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<UserVO> list() {
        @SuppressWarnings("unchecked")
        List<UserVO> listUser = (List<UserVO>) sessionFactory.getCurrentSession()
                .createCriteria(UserVO.class)
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

        return listUser;
    }

    public UserVO getById(int id) {
        return (UserVO) sessionFactory.getCurrentSession()
                .get(UserVO.class, id);
    }

    public void deleteById(int id) {
        UserVO user = (UserVO) sessionFactory.getCurrentSession().get(UserVO.class, id);
        sessionFactory.getCurrentSession().delete(user);
    }

    public UserVO updateUser(UserVO newUser) {
        Session session = sessionFactory.getCurrentSession();
        UserVO exists = (UserVO) session.get(UserVO.class, newUser.getId());
        if (exists != null)
        {
            UserVO admin = (UserVO) session.load(UserVO.class, newUser.getId());
            admin.setPassword(newUser.getPassword());
            admin.setUsername(newUser.getUsername());
            session.save(admin);

            return admin;
        }
        else
        {
            UserVO new_admin = new UserVO(newUser.getUsername(), newUser.getPassword());
            session.save(new_admin);
            return new_admin;
        }
    }

    public UserVO getByNameAndPass(String name, String password) {
        Query query = sessionFactory.getCurrentSession().createSQLQuery(
                "select * from user u where u.Username = :Username and u.Password = :Password")
                .addEntity(UserVO.class)
                .setString("Username", name)
                .setString("Password", password);
        List<UserVO> result = (List<UserVO>) query.list();
        System.out.println("Result: " + result.toString());

        if (result.size() == 1) {
            return result.get(0);
        }
        return null;
    }
}
