package com.se.model.users;

import com.se.database.dao.model.academic.groups.StudentGroupVO;
import com.se.database.dao.model.users.PersonVO;
import com.se.database.dao.model.users.StudentVO;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StudentVOTest {
    private static final int ID = 1;
    private static final String STATUS = "STATUS1";
    private static final String STATUS_NEW = "STATUS2";
    private static final Boolean IS_EXTENDED = true;
    private static final Boolean IS_EXTENDED_NEW = false;
    private StudentVO studentVO;

    private StudentGroupVO studentGroupVO;
    private PersonVO personVO;

    @Before
    public void setUp() throws Exception {
        studentGroupVO = new StudentGroupVO();
        personVO = new PersonVO();

        studentVO = new StudentVO(personVO, studentGroupVO, STATUS, IS_EXTENDED);
        studentVO.setId(ID);
    }

    @After
    public void tearDown() throws Exception {
        studentVO = null;
        personVO = null;
        studentGroupVO = null;
    }

    @Test
    public void getId() throws Exception {
        assertEquals(ID, studentVO.getId());
    }

    @Test
    public void getStatus() throws Exception {
        assertEquals(STATUS, studentVO.getStatus());
    }

    @Test
    public void setStatus() throws Exception {
        studentVO.setStatus(STATUS_NEW);
        assertEquals(STATUS_NEW, studentVO.getStatus());
    }

    @Test
    public void getExtended() throws Exception {
        assertEquals(IS_EXTENDED, studentVO.getExtended());
    }

    @Test
    public void setExtended() throws Exception {
        studentVO.setExtended(IS_EXTENDED_NEW);
        assertEquals(IS_EXTENDED_NEW, studentVO.getExtended());
    }
}
