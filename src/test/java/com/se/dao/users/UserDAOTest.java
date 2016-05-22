//package com.se.dao.users;
//
//import com.se.database.dao.daoImplementation.UserDAOImpl;
//import com.se.database.dao.model.users.UserVO;
//import org.hibernate.SessionFactory;
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.context.transaction.TransactionConfiguration;
//import org.springframework.transaction.annotation.Transactional;
//
//import static org.junit.Assert.*;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations={"classpath*:spring-servlet.xml"})
//public class UserDAOTest {
//    @Qualifier("sessionFactory")
//    @Autowired
//    private SessionFactory sessionFactory;
//
//    private UserDAOImpl userDAO;
//
//    private static final String USERNAME = "user1";
//    private static final String USERNAME_NEW = "user1";
//    private static final String PASSWORD = "password1";
//    private static final String PASSWORD_NEW = "password1";
//    private UserVO userVO;
//
//    @Before
//    public void setUp() throws Exception {
//        userVO = new UserVO(USERNAME, PASSWORD);
//        userDAO = new UserDAOImpl(sessionFactory);
//    }
//
//    @After
//    public void tearDown() throws Exception {
//        sessionFactory = null;
//        userDAO = null;
//        userVO = null;
//    }
//
//    @Test
//    public void updateUser_add() throws Exception {
////        assertEquals(0, userVO.getId());
////        userVO = userDAO.updateUser(userVO);
////        assertNotEquals(0, userVO.getId());
//    }
//}
