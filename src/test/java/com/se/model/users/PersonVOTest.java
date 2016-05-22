package com.se.model.users;


import com.se.database.dao.model.users.PersonVO;
import com.se.database.dao.model.users.UserVO;

import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.*;

public class PersonVOTest {
    private static final int ID = 1;
    private static final String FIRSTNAME = "FNAME1";
    private static final String FIRSTNAME_NEW = "FNAME2";
    private static final String LASTNAME = "LNAME1";
    private static final String LASTNAME_NEW = "LNAME2";
    private static final Date DATE = new Date(System.currentTimeMillis());
    private static final Date DATE_NEW = new Date(System.currentTimeMillis());
    private static final long SSN = 1234;
    private static final long SSN_NEW = 4321;
    private static final String ADDRESS = "ADDRESS1";
    private static final String ADDRESS_NEW = "ADDRESS2";
    private static final int PHONE_NO = 123;
    private static final int PHONE_NO_NEW = 321;
    private PersonVO personVO;


    private static final int USER_ID = 1;
    private static final String USERNAME = "USER1";
    private static final String PASSWORD = "PASSWORD1";
    private UserVO userVO;


    @Before
    public void setUp() throws Exception {
        userVO = new UserVO(USERNAME, PASSWORD);
        userVO.setId(USER_ID);
        personVO = new PersonVO(userVO, FIRSTNAME, LASTNAME, DATE, SSN, ADDRESS, PHONE_NO);
        personVO.setId(ID);
    }

    @After
    public void tearDown() throws Exception {
        personVO = null;
        userVO = null;
    }

    @Test
    public void getId() throws Exception {
        assertEquals(ID, personVO.getId());
    }

    @Test
    public void getFirstName() throws Exception {
        assertEquals(FIRSTNAME, personVO.getFirstName());
    }

    @Test
    public void setFirstName() throws Exception {
        personVO.setFirstName(FIRSTNAME_NEW);
        assertEquals(FIRSTNAME_NEW, personVO.getFirstName());
    }

    @Test
    public void getLastName() throws Exception {
        assertEquals(LASTNAME, personVO.getLastName());
    }

    @Test
    public void setLastName() throws Exception {
        personVO.setLastName(LASTNAME_NEW);
        assertEquals(LASTNAME_NEW, personVO.getLastName());
    }

    @Test
    public void getDob() throws Exception {
        assertEquals(DATE, personVO.getDob());
    }

    @Test
    public void setDob() throws Exception {
        personVO.setDob(DATE_NEW);
        assertEquals(DATE_NEW, personVO.getDob());
    }

    @Test
    public void getSsn() throws Exception {
        assertEquals(SSN, personVO.getSsn());
    }

    @Test
    public void setSsn() throws Exception {
        personVO.setSsn(SSN_NEW);
        assertEquals(SSN_NEW, personVO.getSsn());
    }

    @Test
    public void getAddress() throws Exception {
        assertEquals(ADDRESS, personVO.getAddress());
    }

    @Test
    public void setAddress() throws Exception {
        personVO.setAddress(ADDRESS_NEW);
        assertEquals(ADDRESS_NEW, personVO.getAddress());
    }

    @Test
    public void getPhoneNo() throws Exception {
        assertEquals(PHONE_NO, personVO.getPhoneNo());
    }

    @Test
    public void setPhoneNo() throws Exception {
        personVO.setPhoneNo(PHONE_NO_NEW);
        assertEquals(PHONE_NO_NEW, personVO.getPhoneNo());
    }

    @Test
    public void getUser() throws Exception {
        UserVO personUserVo = personVO.getUserVO();
        assertEquals(USER_ID, personUserVo.getId());
        assertEquals(USERNAME, personUserVo.getUsername());
        assertEquals(PASSWORD, personUserVo.getPassword());
    }
}
