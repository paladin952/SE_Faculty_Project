package com.se.database.dao.interfaces;

import com.se.database.dao.model.users.PersonVO;
import com.se.database.dao.model.users.UserVO;

import java.util.Date;
import java.util.List;

public interface IPersonDAO {

    /**
     * Returns a list of persons
     * @return the list of persons
     */
    List<PersonVO> list();

    /**
     * Returns a personVO having a given id
     * @param id the id to look up
     * @return a personVO (or null if the id doesn't exist)
     */
    PersonVO getByID(int id);

    /**
     * Updates a personVO, using the id passed as argument to identify it
     * @param person the updated personVO
     * @return true if a personVO having the id was updated, false otherwise (false means a new personVO is added)
     */
    PersonVO updateOrSave(PersonVO person);

    /**
     * Deletes a personVO, using the id passed as argument to identify it
     * @param id the personVO's id
     * @return true if a personVO having the id was deleted, false otherwise
     */
    Boolean deleteByID(int id);
}
