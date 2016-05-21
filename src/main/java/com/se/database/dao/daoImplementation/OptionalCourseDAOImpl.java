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
    public OptionalCourseVO updateOrSave(OptionalCourseVO optional_course_vo) {
        Session session = sessionFactory.getCurrentSession();
        OptionalCourseVO exists = (OptionalCourseVO) session.get(OptionalCourseVO.class, optional_course_vo.getId());
        if (exists != null)
        {
            OptionalCourseVO optional_course = (OptionalCourseVO) session.load(OptionalCourseVO.class, optional_course_vo.getId());
            optional_course.setGroupNo(optional_course_vo.getGroupNo())
                    .setCourse(optional_course_vo.getCourse());

            return optional_course;
        }
        else
        {
            OptionalCourseVO new_optional_course = new OptionalCourseVO(optional_course_vo.getGroupNo(), optional_course_vo.getCourse());

            session.save(new_optional_course);
            return new_optional_course;
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
