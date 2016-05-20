package com.se.database.dao.interfaces;

import com.se.database.dao.model.users.PersonVO;
import com.se.database.dao.model.users.ProfessorVO;
import com.se.database.dao.model.users.UserVO;

import java.util.List;

public interface IProfessorDAO {
    /**
     * Returns a list of professors
     * @return The list
     */
    List<ProfessorVO> list();

    /**
     * Returns a professor having a given id
     * @param id the id to look up
     * @return a professor (or null if the id doesn't exist)
     */
    ProfessorVO getByID(int id);

    /**
     * Updates a professor, using the id passed as argument to identify it
     * @param professorVO the updated professor
     */
    ProfessorVO updateOrSave(ProfessorVO professorVO);

    /**
     * Deletes a professor, using the id passed as argument to identify it
     * @param id the professor's id
     * @return true if a professor having the id was deleted, false otherwise
     */
    Boolean deleteByID(int id);

    ProfessorVO getByUser(UserVO userVO);
}
