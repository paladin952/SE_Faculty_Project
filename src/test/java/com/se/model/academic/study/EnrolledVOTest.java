package com.se.model.academic.study;

import com.se.database.dao.model.academic.course.CourseVO;
import com.se.database.dao.model.academic.study.EnrolledVO;
import com.se.database.dao.model.users.StudentVO;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class EnrolledVOTest {
    private StudentVO student;
    private CourseVO course;
    private StudentVO studentNew;
    private CourseVO courseNew;
    private EnrolledVO enrolled;

    @Before
    public void setUp() throws Exception {
        student = new StudentVO();
        course = new CourseVO();
        enrolled = new EnrolledVO(student, course);

        studentNew = new StudentVO();
        courseNew = new CourseVO();
    }

    @After
    public void tearDown() throws Exception {
        enrolled = null;
        student = null;
        course = null;
        studentNew = null;
        courseNew = null;
    }

    @Test
    public void getStudent() throws Exception {
        assertEquals(student, enrolled.getStudent());
    }

    @Test
    public void setStudent() throws Exception {
        enrolled.setStudent(studentNew);
        assertEquals(studentNew, enrolled.getStudent());
    }

    @Test
    public void getCourse() throws Exception {
        assertEquals(course, enrolled.getCourse());
    }

    @Test
    public void setCourse() throws Exception {
        enrolled.setCourse(courseNew);
        assertEquals(courseNew, enrolled.getCourse());
    }
}
