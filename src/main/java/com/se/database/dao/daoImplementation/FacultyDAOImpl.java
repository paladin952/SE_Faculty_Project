package com.se.database.dao.daoImplementation;

import com.se.database.dao.interfaces.IFacultyDAO;
import com.se.database.dao.model.academic.faculty.FacultyVO;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by dana on 5/10/2016.
 */
public class FacultyDAOImpl implements IFacultyDAO {
    private SessionFactory sessionFactory;

    public FacultyDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional
    public List<FacultyVO> list() {
        @SuppressWarnings("unchecked")
        List<FacultyVO> listFaculty = (List<FacultyVO>) sessionFactory.getCurrentSession()
                .createCriteria(FacultyVO.class)
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

        return listFaculty;
    }

    @Transactional
    public FacultyVO getById(int id) {
        return (FacultyVO) sessionFactory.getCurrentSession()
                .get(FacultyVO.class, id);
    }

    @Transactional
    public void deleteById(int id) {
        FacultyVO faculty = (FacultyVO) sessionFactory.getCurrentSession().get(FacultyVO.class, id);
        sessionFactory.getCurrentSession().delete(faculty);
    }

    @Transactional
    public FacultyVO updateFaculty(FacultyVO newFaculty) {
        Session session = sessionFactory.getCurrentSession();
        FacultyVO faculty = (FacultyVO) session.load(FacultyVO.class, newFaculty.getFacultyId());
        if (faculty == null)
        {
            FacultyVO tmp = new FacultyVO(newFaculty.getName());
            session.save(tmp);
            return tmp;
        }
        else
        {
            faculty.setName(newFaculty.getName());
            return faculty;
        }
    }
}
