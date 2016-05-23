package com.se.model.academic.grants;

import com.se.database.dao.model.academic.grants.ScholarshipVO;
import com.se.database.dao.model.academic.grants.StudentScholarshipVO;
import com.se.database.dao.model.academic.groups.StudentGroupVO;
import com.se.database.dao.model.users.PersonVO;
import com.se.database.dao.model.users.StudentVO;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class StudentScholarshipVOTest {
    private static final int ID = 1;
    private StudentScholarshipVO studentScholarshipVO;

    private static final int STUDENT_ID = 1;
    private static final int STUDENT_ID_2 = 2;
    private static final String STATUS = "STATUS1";
    private static final String STATUS_2 = "STATUS2";
    private static final Boolean IS_EXTENDED = true;
    private static final Boolean IS_EXTENDED_2 = false;

    private StudentVO studentVO;
    private StudentVO studentVO_2;

    private static final int SCHOLARSHIP_ID = 1;
    private static final int SCHOLARSHIP_ID_2 = 2;
    private static final String NAME = "NAME1";
    private static final String NAME_2 = "NAME2";
    private static final float SUM = 100;
    private static final float SUM_2 = 1000;
    private ScholarshipVO scholarshipVO;
    private ScholarshipVO scholarshipVO_2;

    @Before
    public void setUp() throws Exception {
        studentVO = new StudentVO(new PersonVO(), new StudentGroupVO(), STATUS, IS_EXTENDED);
        studentVO.setId(STUDENT_ID);
        scholarshipVO = new ScholarshipVO(NAME, SUM);
        scholarshipVO.setId(SCHOLARSHIP_ID);

        studentScholarshipVO = new StudentScholarshipVO(scholarshipVO, studentVO);

        studentVO_2 = new StudentVO(new PersonVO(), new StudentGroupVO(), STATUS_2, IS_EXTENDED_2);
        studentVO_2.setId(STUDENT_ID_2);
        scholarshipVO_2 = new ScholarshipVO(NAME_2, SUM_2);
        scholarshipVO.setId(SCHOLARSHIP_ID_2);
    }

    @After
    public void tearDown() throws Exception {
        studentScholarshipVO = null;
        studentVO_2 = null;
        scholarshipVO_2 = null;
        studentVO = null;
        scholarshipVO = null;
    }

    @Test
    public void getScholarshipVO() throws Exception {
        assertEquals(scholarshipVO, studentScholarshipVO.getScholarshipVO());
    }

    @Test
    public void setScholarshipVO() throws Exception {
        studentScholarshipVO.setScholarshipVO(scholarshipVO_2);
        assertEquals(scholarshipVO_2, studentScholarshipVO.getScholarshipVO());
    }

    @Test
    public void getStudentVO() throws Exception {
        assertEquals(studentVO, studentScholarshipVO.getStudentVO());
    }

    @Test
    public void setStudentVO() throws Exception {
        studentScholarshipVO.setStudentVO(studentVO_2);
        assertEquals(studentVO_2, studentScholarshipVO.getStudentVO());
    }
}
