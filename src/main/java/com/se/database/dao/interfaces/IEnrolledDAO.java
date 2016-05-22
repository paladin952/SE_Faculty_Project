package com.se.database.dao.interfaces;

import com.se.database.dao.model.academic.course.CourseVO;
import com.se.database.dao.model.academic.study.EnrolledVO;
import com.se.database.dao.model.users.StudentVO;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface IEnrolledDAO {
    List<EnrolledVO> list();
    EnrolledVO save(EnrolledVO enrolled);
    List<CourseVO> getEnrolledCoursesForStudent(int id);
    List<StudentVO> getEnrolledStudentsForCourse(String id);
    Boolean deleteByIDs(int student_id, String course_id);
}
