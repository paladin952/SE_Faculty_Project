package com.se.database.dao.interfaces;

import com.se.database.dao.model.academic.course.EvaluationVO;
import com.se.database.dao.model.users.PersonVO;

import java.util.List;

public interface IEvaluationDAO {

    /**
     * Returns a list of evaluations
     * @return The list
     */
    List<EvaluationVO> list();

    /**
     * Returns an evaluation having a given id
     * @param id the id to look up
     * @return an evaluation (or null if the id doesn't exist)
     */
    EvaluationVO getByID(int id);

    /**
     * Updates an evaluation, using the id passed as argument to identify it
     * @param evaluation the updated evaluation
     */
    EvaluationVO updateOrSave(EvaluationVO evaluation);

    /**
     * Deletes an evaluation, using the id passed as argument to identify it
     * @param id the evaluation's id
     * @return true if an evaluation having the id was deleted, false otherwise
     */
    Boolean deleteByID(int id);
}
