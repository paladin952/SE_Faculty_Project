package com.se.database.dao.daoImplementation;

import com.se.database.dao.interfaces.ICourseDAO;
import com.se.database.dao.model.academic.course.CourseVO;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@SuppressWarnings("unchecked")
public class CourseDAOImpl implements ICourseDAO {
    @Autowired
    private SessionFactory sessionFactory;

    public CourseDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<CourseVO> list() {
        return (List<CourseVO>)sessionFactory.getCurrentSession()
                .createCriteria(CourseVO.class)
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)
                .list();
    }

    @Override
    public CourseVO getByID(String id) {
        return (CourseVO) sessionFactory.getCurrentSession().get(CourseVO.class, id);
    }

    @Override
    public CourseVO updateOrSave(CourseVO course) {
        Session session = sessionFactory.getCurrentSession();
        CourseVO exists = (CourseVO) session.get(CourseVO.class, course.getId());
        if (exists != null)
        {
            CourseVO tmp = (CourseVO) session.load(CourseVO.class, course.getId());
            tmp.setAssignedSemester(course.getAssignedSemester())
                .setCredits(course.getCredits())
                .setDegreeVO(course.getDegreeVO())
                .setName(course.getName());

            return tmp;
        }
        else
        {
            CourseVO new_admin = new CourseVO(course.getId(), course.getDegreeVO(), course.getName(), course.getCredits(), course.getAssignedSemester());
            session.save(new_admin);
            return new_admin;
        }
    }

    @Override
    public Boolean deleteByID(String id) {
        Session session = sessionFactory.getCurrentSession();
        CourseVO course = (CourseVO) session.get(CourseVO.class, id);
        if (course == null)
            return false;

        session.delete(course);
        return true;
    }
}
