package com.se.database.dao.interfaces;


import com.se.database.dao.model.academic.grants.ScholarshipVO;

import java.util.List;

public interface IScholarshipDAO {

    /**
     * Returns a list of users
     * @return The list
     */
    List<ScholarshipVO> list();

    /**
     * Get a userVO by id
     * @return The userVO
     */
    ScholarshipVO getById(int id);

    /**
     * Delete a userVO by id
     * @param id The id
     * @return "Success" or "Failure"
     */
    void deleteById(int id);

    /**
     * Update the userVO with a new one
     * @param newScolarship The ScholarshipVO to be updated
     */
    ScholarshipVO updateScholarship(ScholarshipVO newScolarship);

}
