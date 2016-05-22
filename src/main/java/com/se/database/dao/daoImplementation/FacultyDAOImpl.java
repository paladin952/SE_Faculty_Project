package com.se.database.dao.daoImplementation;

import com.se.database.dao.interfaces.IFacultyDAO;
import com.se.database.dao.model.academic.faculty.DegreeVO;
import com.se.database.dao.model.academic.faculty.FacultyVO;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@SuppressWarnings("unchecked")
public class FacultyDAOImpl implements IFacultyDAO {
    @Autowired
    private SessionFactory sessionFactory;

    public FacultyDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<FacultyVO> list() {
        return (List<FacultyVO>) sessionFactory.getCurrentSession()
                .createCriteria(FacultyVO.class)
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)
                .list();
    }

    @Override
    public FacultyVO getByID(int id) {
        return (FacultyVO)sessionFactory.getCurrentSession().get(FacultyVO.class, id);
    }

    @Override
    public List<DegreeVO> getDegreesFor(int id) {
        FacultyVO faculty = getByID(id);
        return faculty != null ? faculty.getDegrees() : null;
    }
}
