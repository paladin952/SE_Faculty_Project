package com.se.database.dao.interfaces;

import com.se.database.dao.model.academic.faculty.DegreeVO;

import java.util.List;

/**
 * Created by dana on 5/22/2016.
 */
public interface IDegreeDAO {
    List<DegreeVO> list();
    DegreeVO getByID(int id);
    DegreeVO updateOrSave(DegreeVO degree);
    Boolean deleteByID(int id);
}
