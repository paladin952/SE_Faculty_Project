package com.se.model.academic.study;

import com.se.database.dao.model.academic.course.EvaluationVO;
import com.se.database.dao.model.academic.study.StudentEvaluationVO;
import com.se.database.dao.model.users.StudentVO;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StudentEvaluationVOTest {
    private EvaluationVO evaluation;
    private StudentVO student;
    private static final float GRADE = 1;
    private static final float GRADE_NEW = 1;
    private static final boolean IS_ABSENT = true;
    private static final boolean IS_ABSENT_NEW = false;
    private StudentEvaluationVO studentEvaluation;

    @Before
    public void setUp() throws Exception {
        evaluation = new EvaluationVO();
        student = new StudentVO();
        studentEvaluation = new StudentEvaluationVO(evaluation, student, GRADE, IS_ABSENT);
    }

    @After
    public void tearDown() throws Exception {
        studentEvaluation = null;
        evaluation = null;
        student = null;
    }

    @Test
    public void getEvaluation() throws Exception {
        assertEquals(evaluation, studentEvaluation.getEvaluationVO());
    }

    @Test
    public void getStudent() throws Exception {
        assertEquals(student, studentEvaluation.getStudentVO());
    }

    @Test
    public void getGrade() throws Exception {
        assertEquals(GRADE, studentEvaluation.getGrade(), 0.0);
    }

    @Test
    public void setGrade() throws Exception {
        studentEvaluation.setGrade(GRADE_NEW);
        assertEquals(GRADE_NEW, studentEvaluation.getGrade(), 0.0);
    }

    @Test
    public void getIsAbsent() throws Exception {
        assertEquals(IS_ABSENT, studentEvaluation.isAbsent());
    }

    @Test
    public void setIsAbsent() throws Exception {
        studentEvaluation.setAbsent(IS_ABSENT_NEW);
        assertEquals(IS_ABSENT_NEW, studentEvaluation.isAbsent());
    }
}
