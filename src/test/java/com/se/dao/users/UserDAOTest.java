//package com.se.dao.users;
//
//import com.se.database.dao.daoImplementation.UserDAOImpl;
//import com.se.database.dao.model.users.UserVO;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.cfg.AnnotationConfiguration;
//import org.hibernate.cfg.Configuration;
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
////@RunWith(SpringJUnit4ClassRunner.class)
////@ContextConfiguration(locations={"classpath:applicationContext.xml"})
//public class UserDAOTest {
////    @Qualifier("sessionFactory")
////    @Autowired
//    private SessionFactory sessionFactory;
////    private Session session = null;
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
////        Configuration configuration = new Configuration();
//        AnnotationConfiguration configuration = new AnnotationConfiguration();
//        configuration.addAnnotatedClass(UserVO.class);
//        configuration.setProperty("hibernate.dialect","org.hibernate.dialect.MySQLDialect");
//        configuration.setProperty("hibernate.connection.driver_class","com.mysql.jdbc.Driver");
//        configuration.setProperty("hibernate.connection.url","jdbc:mysql://localhost:3306/ubbdb");
//        configuration.setProperty("hibernate.connection.username","root");
//        configuration.setProperty("hibernate.connection.password","admin");
//
////        sessionFactory = configuration.configure().buildSessionFactory();
//        sessionFactory = configuration.buildSessionFactory();
//
//
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
//        assertEquals(0, userVO.getId());
//        userVO = userDAO.updateUser(userVO);
//        assertNotEquals(0, userVO.getId());
//        System.out.println(userVO.getId());
//        userDAO.deleteById(userVO.getId());
//    }
//
//    @Test
//    public void deleteById() throws Exception {
//        userDAO.deleteById(11);
//        assertNull(userDAO.getById(11));
//    }
//}
