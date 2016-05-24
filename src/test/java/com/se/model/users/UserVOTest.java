package com.se.model.users;

import com.se.database.dao.model.users.UserVO;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class UserVOTest {
    private static final int ID = 1;
    private static final String USERNAME = "user1";
    private static final String USERNAME_NEW = "user1";
    private static final String PASSWORD = "password1";
    private static final String PASSWORD_NEW = "password1";
    private UserVO userVO;

    @Before
    public void setUp() throws Exception {
        userVO = new UserVO(USERNAME, PASSWORD);
        userVO.setId(ID);
    }

    @After
    public void tearDown() throws Exception {
        userVO = null;
    }

    @Test
    public void getId() throws Exception {
        assertEquals(ID, userVO.getId());
    }

    @Test
    public void getUsername() throws Exception {
        assertEquals(USERNAME, userVO.getUsername());
    }

    @Test
    public void setUsername() throws Exception {
        userVO.setUsername(USERNAME_NEW);
        assertEquals(USERNAME_NEW, userVO.getUsername());
    }

    @Test
    public void getPassword() throws Exception {
        assertEquals(PASSWORD, userVO.getPassword());
    }

    @Test
    public void setPassword() throws Exception {
        userVO.setPassword(PASSWORD_NEW);
        assertEquals(PASSWORD_NEW, userVO.getPassword());

    }
}
