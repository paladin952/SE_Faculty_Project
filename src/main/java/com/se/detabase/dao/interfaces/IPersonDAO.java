package com.se.detabase.dao.interfaces;

import com.se.detabase.dao.model.users.PersonVO;

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
