package com.se.database.dao.interfaces;

import com.se.database.dao.model.academic.course.OptionalCourseVO;
import com.se.database.dao.model.academic.study.StudentOptionalCourseVO;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface IStudentOptionalCourseDAO {
    List<StudentOptionalCourseVO> list();

    IStudentOptionalCourseDAO save(StudentOptionalCourseVO student_optional_course);

    Boolean deleteByIDs(int student_id, String optional_course_id);

    List<OptionalCourseVO> getStudentOptionalCoursesFor(int student_id);

    List<OptionalCourseVO> getStudentOptionalCoursesByGroupFor(int student_id, int optional_course_group);
}
