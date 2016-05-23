package com.se.controller;


import com.se.database.dao.interfaces.IAdminDAO;
import com.se.database.dao.interfaces.IPersonDAO;
import com.se.database.dao.interfaces.IProfessorDAO;
import com.se.database.dao.interfaces.IUserDAO;
import com.se.database.dao.model.users.AdminVO;
import com.se.database.dao.model.users.LoginUserVo;
import com.se.database.dao.model.users.ProfessorVO;
import com.se.database.dao.model.users.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/login")
@CrossOrigin
public class LoginController {

    @Autowired
    IUserDAO iUserDAO;

    @Autowired
    IAdminDAO iAdminDAO;

    @Autowired
    IProfessorDAO iProfessorDAO;

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<LoginUserVo> login(@RequestBody UserVO user){
        System.out.println("Login: " + user.getUsername() + "-" + user.getPassword());

        UserVO existingUser = iUserDAO.getByNameAndPass(user.getUsername(), user.getPassword());

        if(existingUser == null){
            System.out.println("USER DOES NOT EXIST");
            return new ResponseEntity<>(new LoginUserVo(), HttpStatus.NOT_FOUND);
        }else{
            System.out.println("USER EXIST");
            LoginUserVo.UserType userType = getUserType(existingUser);
            return new ResponseEntity<>(new LoginUserVo(existingUser, userType), HttpStatus.OK);
        }
    }

    /**
     * Returns the usertype of the user
     * @param userVO The user to be checked
     * @return {@link LoginUserVo.UserType}
     */
    private LoginUserVo.UserType getUserType(UserVO userVO){
        AdminVO adminVO = iAdminDAO.getByUser(userVO);
        if (adminVO != null){
            System.out.println("UserType=ADMIN");
            return LoginUserVo.UserType.ADMIN;
        }

        ProfessorVO professorVO = iProfessorDAO.getByUser(userVO);
        if (professorVO != null){
            if(professorVO.isChief()){
                System.out.println("TEACHER_CHIEF");
                return LoginUserVo.UserType.TEACHER_CHIEF;
            }else{
                System.out.println("TEACHER");
                return LoginUserVo.UserType.TEACHER;
            }
        }

        System.out.println("UserType=STUDENT");
        return LoginUserVo.UserType.STUDENT;
    }

}
