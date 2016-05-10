package com.se.database.dao.interfaces;

import com.se.database.dao.model.academic.faculty.FacultyVO;

import java.util.List;

/**
 * Created by dana on 5/10/2016.
 */
public interface IFacultyDAO {
    List<FacultyVO> list();

    FacultyVO getById(int id);

    void deleteById(int id);

    FacultyVO updateFaculty(FacultyVO newFaculty);
}
