package com.se.database.dao.interfaces;

import com.se.database.dao.model.academic.faculty.DegreeVO;
import com.se.database.dao.model.academic.faculty.FacultyVO;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface IFacultyDAO {
    List<FacultyVO> list();
    FacultyVO getByID(int id);
    List<DegreeVO> getDegreesFor(int id);
}
