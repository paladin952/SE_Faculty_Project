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

}
