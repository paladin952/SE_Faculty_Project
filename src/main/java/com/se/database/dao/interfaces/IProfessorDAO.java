package com.se.database.dao.interfaces;

import com.se.database.dao.model.users.ProfessorVO;

import java.util.List;

public interface IProfessorDAO {
    /**
     * Returns a list of professors
     * @return The list
     */
    List<ProfessorVO> list();
}
