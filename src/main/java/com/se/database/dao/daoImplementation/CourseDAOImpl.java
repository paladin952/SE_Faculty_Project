package com.se.database.dao.daoImplementation;

import com.se.database.dao.interfaces.ICourseDAO;
import com.se.database.dao.model.academic.course.CourseVO;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by dana on 5/10/2016.
 */
public class CourseDAOImpl implements ICourseDAO {
    private SessionFactory sessionFactory;

    public CourseDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional
    public List<CourseVO> list() {
        @SuppressWarnings("unchecked")
        List<CourseVO> listCourse = (List<CourseVO>) sessionFactory.getCurrentSession()
                .createCriteria(CourseVO.class)
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

        return listCourse;
    }

    @Transactional
    public CourseVO getById(String id) {
        return (CourseVO) sessionFactory.getCurrentSession()
                .get(CourseVO.class, id);
    }

    @Transactional
    public void deleteById(String id) {
        CourseVO course = (CourseVO) sessionFactory.getCurrentSession().get(CourseVO.class, id);
        sessionFactory.getCurrentSession().delete(course);
    }

    @Transactional
    public CourseVO updateCourse(CourseVO newCourse) {
        Session session = sessionFactory.getCurrentSession();
        CourseVO course = (CourseVO) session.load(CourseVO.class, newCourse.getCourseID());
        if (course == null)
        {
            CourseVO tmp =  new CourseVO(newCourse.getCourseID(), newCourse.getDegreeID(), newCourse.getName(), newCourse.getCredits(), newCourse.getEvaluationType(), newCourse.getAssignedSemester());
            session.save(tmp);
            return tmp;
        }
        else
        {
            course.setCourseID(newCourse.getCourseID());
            course.setDegreeID(newCourse.getDegreeID());
            course.setName(newCourse.getName());
            course.setCredits(newCourse.getCredits());
            course.setEvaluationType(newCourse.getEvaluationType());
            course.setAssignedSemester(newCourse.getAssignedSemester());
            return course;
        }
    }
}
