package com.se.database.dao.interfaces;

import com.se.database.dao.model.academic.course.CourseVO;

import java.util.List;

/**
 * Created by dana on 5/10/2016.
 */
public interface ICourseDAO {
    List<CourseVO> list();

    CourseVO getById(String id);

    void deleteById(String id);

    CourseVO updateCourse(CourseVO newCourse);
}
