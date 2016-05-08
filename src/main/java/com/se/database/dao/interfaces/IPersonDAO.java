package com.se.database.dao.interfaces;

import com.se.database.dao.model.users.PersonVO;
import com.se.database.dao.model.users.UserVO;

import java.util.Date;
import java.util.List;

public interface IPersonDAO {

    /**
     * Returns a list of persons
     * @return The list
     */
    List<PersonVO> list();

    /**
     * Returns a person having a given id
     * @param id the id to look up
     * @return a person (or null if the id doesn't exist)
     */
    PersonVO getByID(int id);

    /**
     * Updates a person, using the id passed as argument to identify it
     * @param id the person's id
     * @return true if a person having the id was updated, false otherwise (false means a new person is added)
     */
    PersonVO updateOrSave(int id, String firstName, String lastName, Date dob, long ssn, String address, int phoneNo, UserVO userVO);

    /**
     * Deletes a person, using the id passed as argument to identify it
     * @param id the person's id
     * @return true if a person having the id was deleted, false otherwise
     */
    Boolean deleteByID(int id);
}
