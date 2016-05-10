package com.se.database.dao.interfaces;

import com.se.database.dao.model.academic.faculty.DegreeVO;

import java.util.List;

/**
 * Created by dana on 5/10/2016.
 */
public interface IDegreeDAO {
    List<DegreeVO> list();

    DegreeVO getById(int id);

    void deleteById(int id);

    DegreeVO updateDegree(DegreeVO newDegree);
}
