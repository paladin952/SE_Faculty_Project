package com.se.model.academic.course;

import com.se.database.dao.model.academic.course.CourseVO;
import com.se.database.dao.model.academic.course.EvaluationVO;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class EvaluationVOTest {
    private static final int ID = 1;
    private static final int TYPE = 1;
    private static final int TYPE_NEW = 2;
    private EvaluationVO evaluationVO;

    private CourseVO courseVO;

    @Before
    public void setUp() throws Exception {
        courseVO = new CourseVO();
        evaluationVO = new EvaluationVO(TYPE, courseVO);
        evaluationVO.setId(ID);
    }

    @After
    public void tearDown() throws Exception {
        evaluationVO = null;
        courseVO = null;
    }

    @Test
    public void getId() throws Exception {
        assertEquals(ID, evaluationVO.getId());
    }

    @Test
    public void getType() throws Exception {
        assertEquals(TYPE, evaluationVO.getType());
    }

    @Test
    public void setType() throws Exception {
        evaluationVO.setType(TYPE_NEW);
        assertEquals(TYPE_NEW, evaluationVO.getType());
    }
}
