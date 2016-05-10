package com.se.database.dao.daoImplementation;

import com.se.database.dao.interfaces.IOptionalCourseDAO;
import com.se.database.dao.model.academic.course.OptionalCourseVO;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class OptionalCourseDAOImpl implements IOptionalCourseDAO {

    private SessionFactory sessionFactory;

    public OptionalCourseDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override

    @Transactional
    public List<OptionalCourseVO> list() {
        List<OptionalCourseVO> optionalCourses = (List<OptionalCourseVO>) sessionFactory.getCurrentSession()
                .createCriteria(OptionalCourseVO.class)
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

        return optionalCourses;
    }

    @Override
    @Transactional
    public OptionalCourseVO getByID(int id) {
        return (OptionalCourseVO)sessionFactory.getCurrentSession().get(OptionalCourseVO.class, id);
    }

    @Override
    @Transactional
    public OptionalCourseVO updateOrSave(OptionalCourseVO optionalCourse) {
        Session session = sessionFactory.getCurrentSession();
        OptionalCourseVO tmp = (OptionalCourseVO) session.load(OptionalCourseVO.class, optionalCourse.getCourse());
        if (tmp == null)
        {
            OptionalCourseVO new_optionalCourse = new OptionalCourseVO(optionalCourse.getGroupNo(), optionalCourse.getCourse());
            session.save(new_optionalCourse);

            return new_optionalCourse;
        }
        else
        {
            tmp.setCourse(optionalCourse.getCourse());
            tmp.setGroupNo(optionalCourse.getGroupNo());

            //tmp
            return optionalCourse;
        }
    }

    @Override
    @Transactional
    public Boolean deleteByID(int id) {
        Session session = sessionFactory.getCurrentSession();
        OptionalCourseVO optionalCourseVO = (OptionalCourseVO) session.load(OptionalCourseVO.class, id);
        if (optionalCourseVO == null)
            return false;
        else
            session.delete(optionalCourseVO);

        return true;
    }
}
