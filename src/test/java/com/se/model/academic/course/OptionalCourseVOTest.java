package com.se.model.academic.course;


import com.se.database.dao.model.academic.course.CourseVO;
import com.se.database.dao.model.academic.course.OptionalCourseVO;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class OptionalCourseVOTest {
    private static final int ID = 1;
    private static final int GROUP_NO = 1;
    private static final int GROUP_NO_NEW = 2;
    private OptionalCourseVO optionalCourseVO;

    private CourseVO courseVO;

    @Before
    public void setUp() throws Exception {
        courseVO = new CourseVO();
        optionalCourseVO = new OptionalCourseVO(GROUP_NO, courseVO);
        optionalCourseVO.setId(ID);
    }

    @After
    public void tearDown() throws Exception {
        optionalCourseVO = null;
        courseVO = null;
    }

    @Test
    public void getId() throws Exception {
        assertEquals(ID, optionalCourseVO.getId());
    }

    @Test
    public void getGroupNo() throws Exception {
        assertEquals(GROUP_NO, optionalCourseVO.getGroupNo());
    }

    @Test
    public void setGroupNo() throws Exception {
        optionalCourseVO.setGroupNo(GROUP_NO_NEW);
        assertEquals(GROUP_NO_NEW, optionalCourseVO.getGroupNo());
    }
}
