package com.se.database.dao.daoImplementation;

import com.se.database.dao.interfaces.IDegreeDAO;
import com.se.database.dao.model.academic.faculty.DegreeVO;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SuppressWarnings("unchecked")
@Transactional
public class DegreeDAOImpl implements IDegreeDAO {
    @Autowired
    private SessionFactory sessionFactory;

    public DegreeDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<DegreeVO> list() {
        List<DegreeVO> listDegree = (List<DegreeVO>) sessionFactory.getCurrentSession()
                .createCriteria(DegreeVO.class)
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

        return listDegree;
    }

    @Override
    public DegreeVO getByID(int id) {
        return (DegreeVO) sessionFactory.getCurrentSession()
                .get(DegreeVO.class, id);
    }

    @Override
    public DegreeVO updateOrSave(DegreeVO degree) {
        Session session = sessionFactory.getCurrentSession();
        DegreeVO exists = (DegreeVO) session.get(DegreeVO.class, degree.getId());
        if (exists != null)
        {
            DegreeVO tmp = (DegreeVO) session.load(DegreeVO.class, degree.getId());
            tmp.setField(degree.getField())
                    .setType(degree.getType())
                    .setCourses(degree.getCourses())
                    .setDuration(degree.getDuration())
                    .setFaculty(degree.getFaculty());

            return tmp;
        }
        else
        {
            DegreeVO new_admin = new DegreeVO(degree.getField(), degree.getType(), degree.getDuration(), degree.getFaculty(), degree.getCourses());
            session.save(new_admin);
            return new_admin;
        }
    }

    @Override
    public Boolean deleteByID(int id) {
        Session session = sessionFactory.getCurrentSession();
        DegreeVO degree = (DegreeVO) session.get(DegreeVO.class, id);
        if (degree == null)
            return false;

        session.delete(degree);
        return true;
    }
}
