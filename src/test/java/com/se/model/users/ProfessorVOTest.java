package com.se.model.users;


import com.se.database.dao.model.academic.groups.DepartmentVO;
import com.se.database.dao.model.users.PersonVO;
import com.se.database.dao.model.users.ProfessorVO;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ProfessorVOTest {
    private static final int ID = 1;
    private static final boolean IS_CHIEF = true;
    private static final boolean IS_CHIEF_NEW = false;
    private static final float WAGE = 100;
    private static final float WAGE_NEW = 1000;
    private ProfessorVO professorVO;

    private DepartmentVO departmentVO;
    private PersonVO personVO;

    @Before
    public void setUp() throws Exception {
        departmentVO = new DepartmentVO();
        personVO = new PersonVO();
        professorVO = new ProfessorVO(personVO, departmentVO, IS_CHIEF, WAGE);
        professorVO.setId(ID);
    }

    @After
    public void tearDown() throws Exception {
        professorVO = null;
        personVO = null;
        departmentVO = null;
    }

    @Test
    public void getId() throws Exception {
        assertEquals(ID, professorVO.getId());
    }

    @Test
    public void getWage() throws Exception {
        assertEquals(WAGE, professorVO.getWage(), 0);
    }

    @Test
    public void setWage() throws Exception {
        professorVO.setWage(WAGE_NEW);
        assertEquals(WAGE_NEW, professorVO.getWage(), 0);
    }

    @Test
    public void isChief() throws Exception {
        assertEquals(IS_CHIEF, professorVO.isChief());
    }

    @Test
    public void setChief() throws Exception {
        professorVO.setChief(IS_CHIEF_NEW);
        assertEquals(IS_CHIEF_NEW, professorVO.isChief());
    }
}
