package com.se.database.dao.daoImplementation;

import com.se.database.dao.interfaces.IDepartmentDAO;
import com.se.database.dao.model.academic.groups.DepartmentVO;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class DepartmentDAOImpl implements IDepartmentDAO {

    private SessionFactory sessionFactory;

    public DepartmentDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional
    public List<DepartmentVO> list() {
        @SuppressWarnings("unchecked")
        List<DepartmentVO> departmentVOList = (List<DepartmentVO>) sessionFactory.getCurrentSession()
                .createCriteria(DepartmentVO.class)
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)
                .list();

        return departmentVOList;
    }

    @Override
    @Transactional
    public DepartmentVO getByID(int id) {
        return (DepartmentVO)sessionFactory.getCurrentSession().get(DepartmentVO.class, id);
    }

    @Override
    @Transactional
    public DepartmentVO updateOrSave(DepartmentVO departmentVO) {
        Session session = sessionFactory.getCurrentSession();
        DepartmentVO exists = (DepartmentVO) session.get(DepartmentVO.class, departmentVO.getId());
        if (exists != null)
        {
            DepartmentVO department = (DepartmentVO) session.load(DepartmentVO.class, departmentVO.getId());
            department.setName(departmentVO.getName());
            department.setProfessors(departmentVO.getProfessors());

            return department;
        }
        else
        {
            DepartmentVO new_department = new DepartmentVO(departmentVO.getName(), departmentVO.getProfessors());
            session.save(new_department);
            return new_department;
        }
    }

    @Override
    @Transactional
    public Boolean deleteByID(int id) {
        Session session = sessionFactory.getCurrentSession();
        DepartmentVO departmentVO = (DepartmentVO) session.get(DepartmentVO.class, id);
        if (departmentVO == null)
            return false;
        else
            session.delete(departmentVO);

        return true;
    }
}
