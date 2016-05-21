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
        @SuppressWarnings("unchecked")
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
    public OptionalCourseVO updateOrSave(OptionalCourseVO optionalCourseVO) {
        Session session = sessionFactory.getCurrentSession();
        OptionalCourseVO exists = (OptionalCourseVO) session.get(OptionalCourseVO.class, optionalCourseVO.getId());
        if (exists != null)
        {
            OptionalCourseVO optionalCourse = (OptionalCourseVO) session.load(OptionalCourseVO.class, optionalCourseVO.getId());
            optionalCourse.setGroupNo(optionalCourseVO.getGroupNo());
                    //.setCourse(optionalCourseVO.getCourse());

            return optionalCourse;
        }
        else
        {
            OptionalCourseVO new_admin = new OptionalCourseVO(optionalCourseVO.getGroupNo());
            session.save(new_admin);
            return new_admin;
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
