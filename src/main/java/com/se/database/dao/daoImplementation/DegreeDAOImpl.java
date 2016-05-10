package com.se.database.dao.daoImplementation;

import com.se.database.dao.interfaces.IDegreeDAO;
import com.se.database.dao.model.academic.faculty.DegreeVO;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by dana on 5/10/2016.
 */
public class DegreeDAOImpl implements IDegreeDAO {
    private SessionFactory sessionFactory;

    public DegreeDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional
    public List<DegreeVO> list() {
        @SuppressWarnings("unchecked")
        List<DegreeVO> listDegree = (List<DegreeVO>) sessionFactory.getCurrentSession()
                .createCriteria(DegreeVO.class)
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

        return listDegree;
    }

    @Transactional
    public DegreeVO getById(int id) {
        return (DegreeVO) sessionFactory.getCurrentSession()
                .get(DegreeVO.class, id);
    }

    @Transactional
    public void deleteById(int id) {
        DegreeVO degree = (DegreeVO) sessionFactory.getCurrentSession().get(DegreeVO.class, id);
        sessionFactory.getCurrentSession().delete(degree);
    }

    @Transactional
    public DegreeVO updateDegree(DegreeVO newDegree) {
        Session session = sessionFactory.getCurrentSession();
        DegreeVO degree = (DegreeVO) session.load(DegreeVO.class, newDegree.getDegreeId());
        if (degree == null)
        {
            DegreeVO tmp = new DegreeVO(newDegree.getField(), newDegree.getType(), newDegree.getDuration(), newDegree.getFaculty());
            session.save(tmp);
            return tmp;
        }
        else
        {
            degree.setField(newDegree.getField());
            degree.setType(newDegree.getType());
            degree.setDuration(newDegree.getDuration());
            degree.setFaculty(newDegree.getFaculty());
            return degree;
        }
    }
}
