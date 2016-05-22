package com.se.model.academic.course;

import com.se.database.dao.model.academic.course.CourseVO;
import com.se.database.dao.model.academic.course.activities.ActivityVO;
import com.se.database.dao.model.academic.faculty.DegreeVO;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class CourseVOTest {
    private static final String ID = "C1";
    private static final String NAME = "COURSE1";
    private static final String NAME_NEW = "COURSE2";
    private static final int CREDITS = 1;
    private static final int CREDITS_NEW = 2;
    private static final int ASSIGNED_SEMESTER = 1;
    private static final int ASSIGNED_SEMESTER_NEW = 2;
    private static final List<ActivityVO> ACTIVITY_LIST = Arrays.asList(new ActivityVO(), new ActivityVO());
    private static final List<ActivityVO> ACTIVITY_LIST_NEW = Arrays.asList(new ActivityVO());
    private CourseVO courseVO;

    private DegreeVO degreeVO;

    @Before
    public void setUp() throws Exception {
        degreeVO = new DegreeVO();
        courseVO = new CourseVO(degreeVO, NAME, CREDITS, ASSIGNED_SEMESTER, ACTIVITY_LIST);
        courseVO.setId(ID);
    }

    @After
    public void tearDown() throws Exception {
        courseVO = null;
        degreeVO = null;
    }

    @Test
    public void getId() throws Exception {
        assertEquals(ID, courseVO.getId());
    }

    @Test
    public void getName() throws Exception {
        assertEquals(NAME, courseVO.getName());
    }

    @Test
    public void setName() throws Exception {
        courseVO.setName(NAME_NEW);
        assertEquals(NAME_NEW, courseVO.getName());
    }

    @Test
    public void getCredits() throws Exception {
        assertEquals(CREDITS, courseVO.getCredits());
    }

    @Test
    public void setCredits() throws Exception {
        courseVO.setCredits(CREDITS_NEW);
        assertEquals(CREDITS_NEW, courseVO.getCredits());
    }

    @Test
    public void getAssignedSemester() throws Exception {
        assertEquals(ASSIGNED_SEMESTER, courseVO.getAssignedSemester());
    }

    @Test
    public void setAssignedSemester() throws Exception {
        courseVO.setAssignedSemester(ASSIGNED_SEMESTER_NEW);
        assertEquals(ASSIGNED_SEMESTER_NEW, courseVO.getAssignedSemester());
    }

    @Test
    public void getActivities() throws Exception {
        assertEquals(ACTIVITY_LIST, courseVO.getActivities());
    }

    @Test
    public void setActivities() throws Exception {
        courseVO.setActivities(ACTIVITY_LIST_NEW);
        assertEquals(ACTIVITY_LIST_NEW, courseVO.getActivities());
    }
}
