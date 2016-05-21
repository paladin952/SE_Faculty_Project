package com.se.controller;

import com.se.database.dao.interfaces.IUserDAO;
import com.se.database.dao.model.users.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/user")
@CrossOrigin
public class UserController {

    @Autowired
    private IUserDAO iUserDAO;

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<UserVO> deleteUserById(@PathVariable(value = "id") int id) {
        iUserDAO.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/add", method = RequestMethod.PUT)
    public ResponseEntity<UserVO> updateUser(@RequestBody UserVO user) {
        System.out.println("Add/update User " + user.toString());
        iUserDAO.updateUser(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<UserVO> getUserById(@PathVariable(value = "id") int id) {
        UserVO userVO = iUserDAO.getById(id);
        return new ResponseEntity<>(userVO, userVO != null ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<List<UserVO>> home() {
        List<UserVO> users = iUserDAO.list();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
}
