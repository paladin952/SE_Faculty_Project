package com.se.database.dao.interfaces;

import com.se.database.dao.model.academic.course.activities.ActivityVO;

import java.util.List;

public interface IActivityDAO {
    List<ActivityVO> list();
    ActivityVO getByID(int id);
    ActivityVO updateOrSave(ActivityVO activity);
    Boolean deleteByID(int id);
}
