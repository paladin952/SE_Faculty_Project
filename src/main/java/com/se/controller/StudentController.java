package com.se.controller;

import com.se.database.dao.interfaces.IStudentDAO;
import com.se.database.dao.model.users.StudentVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private IStudentDAO iStudentDAO;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<List<StudentVO>> getStudents() {
        List<StudentVO> students = iStudentDAO.list();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

}
