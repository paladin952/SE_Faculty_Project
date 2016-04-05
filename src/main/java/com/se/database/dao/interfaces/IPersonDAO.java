package com.se.database.dao.interfaces;

import com.se.database.dao.model.users.PersonVO;

import java.util.List;

/**
 * Created by Clapa Lucian on 4/5/2016.
 */
public interface IPersonDAO {

    /**
     * Returns a list of persons
     * @return The list
     */
    List<PersonVO> list();

}
