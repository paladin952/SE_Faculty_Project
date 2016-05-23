package com.se.model.academic.groups;

import com.se.database.dao.model.academic.groups.StudentGroupVO;
import com.se.database.dao.model.users.StudentVO;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class StudentGroupVOTest {
    private static final int ID = 1;
    private static final int CURRENT_SEMESTER = 1;
    private static final int CURRENT_SEMESTER_NEW = 2;
    private static final List<StudentVO> STUDENTS = Arrays.asList(new StudentVO());
    private static final List<StudentVO> STUDENTS_NEW = Arrays.asList(new StudentVO(), new StudentVO());
    private StudentGroupVO studentGroup;

    @Before
    public void setUp() throws Exception {
        studentGroup = new StudentGroupVO(ID, STUDENTS, CURRENT_SEMESTER);
    }

    @Test
    public void getId() throws Exception {
        assertEquals(ID, studentGroup.getId());
    }

    @Test
    public void getCurrentSemester() throws Exception {
        assertEquals(CURRENT_SEMESTER, studentGroup.getCurrentSemester());
    }

    @Test
    public void setCurrentSemester() throws Exception {
        studentGroup.setCurrentSemester(CURRENT_SEMESTER_NEW);
        assertEquals(CURRENT_SEMESTER_NEW, studentGroup.getCurrentSemester());
    }

    @Test
    public void getStudents() throws Exception {
        assertEquals(STUDENTS, studentGroup.getStudents());
    }

    @Test
    public void setStudents() throws Exception {
        studentGroup.setStudents(STUDENTS_NEW);
        assertEquals(STUDENTS_NEW, studentGroup.getStudents());
    }
}
