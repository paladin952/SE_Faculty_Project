package com.se.controller;


import com.se.database.dao.interfaces.IScholarshipDAO;
import com.se.database.dao.model.academic.grants.ScholarshipVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/scholarship")
public class ScholarshipController {


    @Autowired
    private IScholarshipDAO iScholarshipDAO;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<List<ScholarshipVO>> getProfessors () {
        List<ScholarshipVO> scholarshipList = iScholarshipDAO.list();
        return new ResponseEntity<>(scholarshipList, HttpStatus.OK);
    }

}
