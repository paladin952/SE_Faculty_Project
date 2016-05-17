package com.se.controller;


import com.se.database.dao.interfaces.IStudentScholarshipDAO;
import com.se.database.dao.model.academic.grants.StudentScholarshipVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/studentscholarship")
@CrossOrigin
public class StudentScholarshipController {

    @Autowired
    private IStudentScholarshipDAO iStudentScholarshipDAO;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<List<StudentScholarshipVO>> getStudents() {
        List<StudentScholarshipVO> students = iStudentScholarshipDAO.list();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }


}
