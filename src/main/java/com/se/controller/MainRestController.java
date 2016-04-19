package com.se.controller;

import com.se.database.dao.interfaces.IPersonDAO;
import com.se.database.dao.interfaces.IProfessorDAO;
import com.se.database.dao.interfaces.IStudentDAO;
import com.se.database.dao.interfaces.IUserDAO;
import com.se.database.dao.model.users.PersonVO;
import com.se.database.dao.model.users.ProfessorVO;
import com.se.database.dao.model.users.StudentVO;
import com.se.database.dao.model.users.UserVO;
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
    private IUserDAO iUserDao;

    @Autowired
    private IPersonDAO iPersonDAO;

    @Autowired
    private IStudentDAO iStudentDAO;

    @Autowired
    private IProfessorDAO iProfessorDAO;

    @RequestMapping(value = "/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String home(Model model) {
        List<UserVO> listUsers = iUserDao.list();
        model.addAttribute(JsonConstants.ROOT_USERS, listUsers);
        return JsonConstants.JSON_TEMPLATE;
    }

    @RequestMapping(value = "/persons", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String getPersons(Model model) {
        List<PersonVO> personList = iPersonDAO.list();
        model.addAttribute(JsonConstants.ROOT_PERSONS, personList);
        return JsonConstants.JSON_TEMPLATE;
    }

    @RequestMapping(value = "/students", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String getStudents(Model model) {
        List<StudentVO> studentList = iStudentDAO.list();
        model.addAttribute(JsonConstants.ROOT_STUDENTS, studentList);
        return JsonConstants.JSON_TEMPLATE;
    }

    @RequestMapping(value = "/professors", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String getProfessors(Model model) {
        List<ProfessorVO> professorList = iProfessorDAO.list();
        model.addAttribute(JsonConstants.ROOT_PROFESSORS, professorList);
        return JsonConstants.JSON_TEMPLATE;
    }
}

