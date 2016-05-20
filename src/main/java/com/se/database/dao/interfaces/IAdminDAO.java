package com.se.database.dao.interfaces;

import com.se.database.dao.model.users.AdminVO;
import com.se.database.dao.model.users.UserVO;

import java.util.List;

public interface IAdminDAO {
    /**
     * Returns a list of admins
     * @return The list
     */
    List<AdminVO> list();

    /**
     * Returns an admin having a given id
     * @param id the id to look up
     * @return an admin (or null if the id doesn't exist)
     */
    AdminVO getByID(int id);

    /**
     * Updates an admin, using the id passed as argument to identify it
     * @param adminVO the updated department
     */
    AdminVO updateOrSave(AdminVO adminVO);

    /**
     * Deletes an admin, using the id passed as argument to identify it
     * @param id the admin's id
     * @return true if an admin having AdminID equal to id was deleted, false otherwise
     */
    Boolean deleteByID(int id);

    AdminVO getByUser(UserVO userVO);
}
