package com.se.database.dao.interfaces;

import com.se.database.dao.model.users.StudentVO;

import java.util.List;

public interface IStudentDAO {
    /**
     * Returns a list of students
     * @return The list
     */
    List<StudentVO> list();

    StudentVO getByID(int id);

    StudentVO updateOrSave(StudentVO studentVO);

    Boolean deleteByID(int id);
}
