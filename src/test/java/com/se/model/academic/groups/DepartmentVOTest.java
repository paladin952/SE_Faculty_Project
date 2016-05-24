package com.se.model.academic.groups;

import com.se.database.dao.model.academic.groups.DepartmentVO;
import com.se.database.dao.model.users.ProfessorVO;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class DepartmentVOTest {
    private static final int ID = 1;
    private static final String NAME = "Name";
    private static final String NAME_NEW = "NewName";
    private static Set<ProfessorVO> professors;
    private static Set<ProfessorVO> professorsNew;
    private DepartmentVO department;

    @Before
    public void setUp() throws Exception {
        professors = new HashSet<>();
        professors.add(new ProfessorVO());
        professorsNew = new HashSet<>();
        professorsNew.add(new ProfessorVO());
        professorsNew.add(new ProfessorVO());

        department = new DepartmentVO(NAME, professors);
        department.setId(ID);
    }

    @After
    public void tearDown() throws Exception {
        department = null;
        professors = null;
        professorsNew = null;
    }

    @Test
    public void getId() throws Exception {
        assertEquals(ID, department.getId());
    }

    @Test
    public void getName() throws Exception {
        assertEquals(NAME, department.getName());
    }

    @Test
    public void setName() throws Exception {
        department.setName(NAME_NEW);
        assertEquals(NAME_NEW, department.getName());
    }

    @Test
    public void getProfessors() throws Exception {
        assertEquals(professors, department.getProfessors());
    }

    @Test
    public void setProfessors() throws Exception {
        department.setProfessors(professorsNew);
        assertEquals(professorsNew, department.getProfessors());
    }
}
