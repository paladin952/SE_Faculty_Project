package com.se.database.dao.daoImplementation;

import com.se.database.dao.interfaces.IActivityDAO;
import com.se.database.dao.model.academic.course.activities.ActivityVO;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by dana on 5/10/2016.
 */
public class ActivityDAOImpl implements IActivityDAO {
    private SessionFactory sessionFactory;

    public ActivityDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional
    public List<ActivityVO> list() {
        @SuppressWarnings("unchecked")
        List<ActivityVO> activityList = (List<ActivityVO>) sessionFactory.getCurrentSession()
                .createCriteria(ActivityVO.class)
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

        return activityList;
    }

    @Transactional
    public ActivityVO getById(int id) {
        return (ActivityVO) sessionFactory.getCurrentSession()
                .get(ActivityVO.class, id);
    }

    @Transactional
    public void deleteById(int id) {
        ActivityVO activity = (ActivityVO) sessionFactory.getCurrentSession().get(ActivityVO.class, id);
        sessionFactory.getCurrentSession().delete(activity);
    }

    @Transactional
    public ActivityVO updateActivity(ActivityVO newActivity) {
        Session session = sessionFactory.getCurrentSession();
        ActivityVO activity = (ActivityVO) session.load(ActivityVO.class, newActivity.getActivityId());
        if (activity == null)
        {
            ActivityVO tmp = new ActivityVO(newActivity.getActivityType(), newActivity.getCourseVo());
            session.save(tmp);
            return tmp;
        }
        else
        {
            activity.setActivityType(newActivity.getActivityType());
            activity.setCourseVo(newActivity.getCourseVo());
            return activity;
        }
    }
}
