package com.se.database.dao.interfaces;

import com.se.database.dao.model.academic.course.CourseVO;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface ICourseDAO {
    List<CourseVO> list();
    CourseVO getByID(String id);
    CourseVO updateOrSave(CourseVO course);
    Boolean deleteByID(String id);
}
