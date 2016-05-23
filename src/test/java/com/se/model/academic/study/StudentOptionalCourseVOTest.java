package com.se.model.academic.study;

import com.se.database.dao.model.academic.course.CourseVO;
import com.se.database.dao.model.academic.study.StudentOptionalCourseVO;
import com.se.database.dao.model.users.StudentVO;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StudentOptionalCourseVOTest {
    private CourseVO course;
    private StudentVO student;
    private StudentOptionalCourseVO studentOptionalCourse;

    @Before
    public void setUp() throws Exception {
        course = new CourseVO();
        student = new StudentVO();
        studentOptionalCourse = new StudentOptionalCourseVO(course, student);
    }

    @After
    public void tearDown() throws Exception {
        studentOptionalCourse = null;
        student = null;
        course = null;
    }

    @Test
    public void getCourse() throws Exception {
        assertEquals(course, studentOptionalCourse.getCourseVO());
    }

    @Test
    public void getStudent() throws Exception {
        assertEquals(student, studentOptionalCourse.getStudentVO());
    }
}
