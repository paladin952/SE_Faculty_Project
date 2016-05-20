package com.se.controller;


import com.se.database.dao.interfaces.IUserDAO;
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

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<UserVO> login(@RequestBody UserVO user){
        System.out.println("Login: " + user.getUsername() + "-" + user.getPassword());

        UserVO existingUser = iUserDAO.getByNameAndPass(user.getUsername(), user.getPassword());

        if(existingUser == null){
            return new ResponseEntity<UserVO>(new UserVO(), HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<UserVO>(existingUser, HttpStatus.OK);
        }
    }

}
