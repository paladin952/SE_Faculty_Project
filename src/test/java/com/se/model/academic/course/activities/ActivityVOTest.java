package com.se.model.academic.course.activities;

import com.se.database.dao.model.academic.course.CourseVO;
import com.se.database.dao.model.academic.course.activities.ActivityVO;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ActivityVOTest {
    private static final int ID=1;
    private static final int HOURS_PER_WEEK = 6;
    private static final int HOURS_PER_WEEK_NEW = 4;
    private static final int ACTIVITY_TYPE = 2;
    private static final int ACTIVITY_TYPE_NEW = 1;
    private ActivityVO activityVO;

    private CourseVO courseVO;

    @Before
    public void setUp() throws Exception {
        courseVO = new CourseVO();
        activityVO = new ActivityVO(HOURS_PER_WEEK, ACTIVITY_TYPE, courseVO);
        activityVO.setId(ID);
    }

    @After
    public void tearDown() throws Exception {
        activityVO = null;
        courseVO = null;
    }

    @Test
    public void getId() throws Exception {
        assertEquals(ID, activityVO.getID());
    }

    @Test
    public void getHours_per_week() throws Exception {
        assertEquals(HOURS_PER_WEEK, activityVO.getHours_per_week());
    }

    @Test
    public void setHours_per_week() throws Exception {
        activityVO.setHours_per_week(HOURS_PER_WEEK_NEW);
        assertEquals(HOURS_PER_WEEK_NEW, activityVO.getHours_per_week());
    }

    @Test
    public void getActivity_type() throws Exception {
        assertEquals(ACTIVITY_TYPE, activityVO.getActivity_type());
    }

    @Test
    public void setActivity_type() throws Exception {
        activityVO.setActivity_type(ACTIVITY_TYPE_NEW);
        assertEquals(ACTIVITY_TYPE_NEW, activityVO.getActivity_type());
    }


}
