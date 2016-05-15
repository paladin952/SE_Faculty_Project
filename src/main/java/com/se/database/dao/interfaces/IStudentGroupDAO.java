package com.se.database.dao.interfaces;

import com.se.database.dao.model.academic.groups.StudentGroupVO;

import java.util.List;

public interface IStudentGroupDAO {
    List<StudentGroupVO> list();
    StudentGroupVO getByID(int id);
    StudentGroupVO updateOrSave(StudentGroupVO student_group);
    Boolean deleteByID(int id);
}
