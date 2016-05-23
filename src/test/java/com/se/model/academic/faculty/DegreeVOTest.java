package com.se.model.academic.faculty;


import com.se.database.dao.model.academic.course.CourseVO;
import com.se.database.dao.model.academic.faculty.DegreeVO;
import com.se.database.dao.model.academic.faculty.FacultyVO;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class DegreeVOTest {
    private static final int ID = 1;
    private static final String FIELD = "FIELD1";
    private static final String FIELD_NEW = "FIELD2";
    private static final int TYPE = 1;
    private static final int TYPE_NEW = 2;
    private static final int DURATION = 2;
    private static final int DURATION_NEW = 3;
    private static final List<CourseVO> COURSE_LIST = Arrays.asList(new CourseVO(), new CourseVO());
    private static final List<CourseVO> COURSE_LIST_NEW = Arrays.asList(new CourseVO(), new CourseVO(), new CourseVO());
    private DegreeVO degreeVO;

    private FacultyVO facultyVO;

    @Before
    public void setUp() throws Exception {
        facultyVO = new FacultyVO();
        degreeVO = new DegreeVO(FIELD, TYPE, DURATION, facultyVO, COURSE_LIST);
        degreeVO.setId(ID);
    }

    @After
    public void tearDown() throws Exception {
        degreeVO = null;
        facultyVO = null;
    }

    @Test
    public void getId() throws Exception {
        assertEquals(ID, degreeVO.getId());
    }

    @Test
    public void getField() throws Exception {
        assertEquals(FIELD, degreeVO.getField());
    }

    @Test
    public void setField() throws Exception {
        degreeVO.setField(FIELD_NEW);
        assertEquals(FIELD_NEW, degreeVO.getField());
    }

    @Test
    public void getType() throws Exception {
        assertEquals(TYPE, degreeVO.getType());
    }

    @Test
    public void setType() throws Exception {
        degreeVO.setType(TYPE_NEW);
        assertEquals(TYPE_NEW, degreeVO.getType());
    }

    @Test
    public void getDuration() throws Exception {
        assertEquals(DURATION, degreeVO.getDuration());
    }

    @Test
    public void setDuration() throws Exception {
        degreeVO.setDuration(DURATION_NEW);
        assertEquals(DURATION_NEW, degreeVO.getDuration());
    }

    @Test
    public void getCourses() throws Exception {
        assertEquals(COURSE_LIST, degreeVO.getCourses());
    }

    @Test
    public void setCourses() throws Exception {
        degreeVO.setCourses(COURSE_LIST_NEW);
        assertEquals(COURSE_LIST_NEW, degreeVO.getCourses());
    }
}
