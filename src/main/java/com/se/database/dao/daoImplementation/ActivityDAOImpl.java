package com.se.database.dao.daoImplementation;

import com.se.database.dao.interfaces.IActivityDAO;
import com.se.database.dao.model.academic.course.activities.ActivityVO;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SuppressWarnings("unchecked")
@Transactional
public class ActivityDAOImpl implements IActivityDAO {
    @Autowired
    private SessionFactory sessionFactory;

    public ActivityDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<ActivityVO> list() {
        List<ActivityVO> activityList = (List<ActivityVO>) sessionFactory.getCurrentSession()
                .createCriteria(ActivityVO.class)
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)
                .list();

        return activityList;
    }

    @Override
    public ActivityVO getByID(int id) {
        return (ActivityVO) sessionFactory.getCurrentSession()
                .get(ActivityVO.class, id);
    }

    @Override
    public ActivityVO updateOrSave(ActivityVO activity) {
        Session session = sessionFactory.getCurrentSession();
        ActivityVO exists = (ActivityVO) session.get(ActivityVO.class, activity.getID());
        if (exists != null)
        {
            ActivityVO tmp = (ActivityVO) session.load(ActivityVO.class, activity.getID());
            tmp.setHours_per_week(activity.getHours_per_week())
                    .setActivity_type(activity.getActivity_type())
                    .setCourse(activity.getCourse());

            return tmp;
        }
        else
        {
            ActivityVO new_admin = new ActivityVO(activity.getActivity_type(), activity.getHours_per_week(), activity.getCourse());
            session.save(new_admin);
            return new_admin;
        }
    }

    @Override
    public Boolean deleteByID(int id) {
        Session session = sessionFactory.getCurrentSession();
        ActivityVO activity = (ActivityVO) session.get(ActivityVO.class, id);
        if (activity == null)
            return false;

        session.delete(activity);
        return true;
    }
}
