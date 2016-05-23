package com.se.model.academic.faculty;

import com.se.database.dao.model.academic.faculty.DegreeVO;
import com.se.database.dao.model.academic.faculty.FacultyVO;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;


public class FacultyVOTest {
    private static final int ID = 1;
    private static final String NAME = "NAME1";
    private static final String NAME_NEW = "NAME2";
    private static final List<DegreeVO> DEGREE_LIST = Arrays.asList(new DegreeVO(), new DegreeVO());
    private static final List<DegreeVO> DEGREE_LIST_NEW = Arrays.asList(new DegreeVO(), new DegreeVO(), new DegreeVO());
    private FacultyVO facultyVO;

    @Before
    public void setUp() throws Exception {
        facultyVO = new FacultyVO(NAME);
        facultyVO.setId(ID);
        facultyVO.setDegrees(DEGREE_LIST);
    }

    @After
    public void tearDown() throws Exception {
        facultyVO = null;
    }

    @Test
    public void getId() throws Exception {
        assertEquals(ID, facultyVO.getId());
    }

    @Test
    public void getName() throws Exception {
        assertEquals(NAME, facultyVO.getName());
    }

    @Test
    public void setName() throws Exception {
        facultyVO.setName(NAME_NEW);
        assertEquals(NAME_NEW, facultyVO.getName());
    }

    @Test
    public void getDegrees() throws Exception {
        assertEquals(DEGREE_LIST, facultyVO.getDegrees());
    }

    @Test
    public void setDegrees() throws Exception {
        facultyVO.setDegrees(DEGREE_LIST_NEW);
        assertEquals(DEGREE_LIST_NEW, facultyVO.getDegrees());
    }
}
