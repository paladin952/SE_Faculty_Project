package com.se.controller;

import com.se.detabase.dao.interfaces.UserDAO;
import com.se.detabase.dao.model.users.UserVO;
import com.se.util.JsonConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;



@Controller("/")
public class MainRestController {

    @Autowired
    private UserDAO userDao;

    @RequestMapping(value = "/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String home(Model model) {
        List<UserVO> listUsers = userDao.list();
        model.addAttribute(JsonConstants.ROOT_USERS, listUsers);
        return JsonConstants.JSON_TEMPLATE;
    }

}

