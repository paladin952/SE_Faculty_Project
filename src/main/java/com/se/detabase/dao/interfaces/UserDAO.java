package com.se.detabase.dao.interfaces;

import com.se.detabase.dao.model.users.UserVO;

import java.util.List;

/**
 * Created by Clapa Lucian on 4/3/2016.
 */
public interface UserDAO {

    List<UserVO> list();

}
