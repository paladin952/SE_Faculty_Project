package com.se.database.dao.daoImplementation;

import com.se.database.dao.interfaces.IAdminDAO;
import com.se.database.dao.model.users.AdminVO;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public class AdminDAOImpl implements IAdminDAO {
    private SessionFactory sessionFactory;

    public AdminDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional
    public List<AdminVO> list() {
        @SuppressWarnings("unchecked")
        List<AdminVO> admins = (List<AdminVO>) sessionFactory.getCurrentSession()
                .createCriteria(AdminVO.class)
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)
                .list();

        return admins;
    }

    @Override
    @Transactional
    public AdminVO getByID(int id) {
        return (AdminVO) sessionFactory.getCurrentSession().get(AdminVO.class, id);
    }

    @Override
    @Transactional
    public AdminVO updateOrSave(AdminVO adminVO) {
        Session session = sessionFactory.getCurrentSession();
        AdminVO exists = (AdminVO) session.get(AdminVO.class, adminVO.getId());
        if (exists != null)
        {
            AdminVO admin = (AdminVO) session.load(AdminVO.class, adminVO.getId());
            admin.setUserVO(adminVO.getUserVO());

            return admin;
        }
        else
        {
            AdminVO new_admin = new AdminVO(adminVO.getUserVO());
            session.save(new_admin);
            return new_admin;
        }
    }

    @Override
    @Transactional
    public Boolean deleteByID(int id) {
        Session session = sessionFactory.getCurrentSession();
        AdminVO admin = (AdminVO)session.get(AdminVO.class, id);
        if (admin == null)
            return false;

        session.delete(admin);
        return true;
    }
}
