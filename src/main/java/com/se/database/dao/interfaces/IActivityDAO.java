package com.se.database.dao.interfaces;

import com.se.database.dao.model.academic.course.activities.ActivityVO;

import java.util.List;

/**
 * Created by dana on 5/10/2016.
 */
public interface IActivityDAO {
    List<ActivityVO> list();

    ActivityVO getById(int id);

    void deleteById(int id);

    ActivityVO updateActivity(ActivityVO newActivity);
}
