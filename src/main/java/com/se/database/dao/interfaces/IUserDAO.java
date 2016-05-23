package com.se.database.dao.interfaces;

import com.se.database.dao.model.users.UserVO;

import java.util.List;

/**
 * Created by Clapa Lucian on 4/3/2016.
 */
public interface IUserDAO {

    /**
     * Returns a list of users
     * @return The list
     */
    List<UserVO> list();

    /**
     * Get a userVO by id
     * @return The userVO
     */
    UserVO getById(int id);

    /**
     * Delete a userVO by id
     * @param id The id
     * @return "Success" or "Failure"
     */
    void deleteById(int id);

    /**
     * Update the userVO with a new one
     * @param newUser The userVO to be updated
     */
    UserVO updateUser(UserVO newUser);

    /**
     * Get a userVO by name and password
     * USED FOR LOGIN
     * @param name The name to be checked
     * @param password The password
     * @return an existing userVO or null
     */
    UserVO getByNameAndPass(String name, String password);

}
