package com.se.controller;


import com.se.database.dao.interfaces.IScholarshipDAO;
import com.se.database.dao.model.academic.grants.ScholarshipVO;
import com.se.database.dao.model.users.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/scholarship")
@CrossOrigin
public class ScholarshipController {


    @Autowired
    private IScholarshipDAO iScholarshipDAO;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<List<ScholarshipVO>> getProfessors () {
        List<ScholarshipVO> scholarshipList = iScholarshipDAO.list();
        return new ResponseEntity<>(scholarshipList, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<ScholarshipVO> deleteUserById(@PathVariable(value = "id") int id) {
        iScholarshipDAO.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/add", method = RequestMethod.PUT)
    public ResponseEntity<ScholarshipVO> updateUser(@RequestBody ScholarshipVO scholarshipVO) {
        System.out.println("Updating User " + scholarshipVO.getId());
        ScholarshipVO tmp = iScholarshipDAO.updateScholarship(scholarshipVO);
        return new ResponseEntity<>(tmp, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<ScholarshipVO> getUserById(@PathVariable(value = "id") int id) {
        ScholarshipVO scholarshipVO = iScholarshipDAO.getById(id);
        return new ResponseEntity<>(scholarshipVO, scholarshipVO != null ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

}
