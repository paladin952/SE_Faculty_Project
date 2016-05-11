package com.se.controller;


import com.se.database.dao.interfaces.IProfessorDAO;
import com.se.database.dao.model.users.ProfessorVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/professor")
public class ProfessorController {

    @Autowired
    private IProfessorDAO iProfessorDAO;

        @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<List<ProfessorVO>> getProfessors () {
        List<ProfessorVO> professors = iProfessorDAO.list();
        return new ResponseEntity<>(professors, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<ProfessorVO> getProfessor(
            @PathVariable("id") int id) {
        ProfessorVO professorVO = iProfessorDAO.getByID(id);
        return new ResponseEntity<>(professorVO, professorVO != null ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/add", method = RequestMethod.PUT)
    public ResponseEntity<ProfessorVO> updateProfessor(
            @RequestBody ProfessorVO professorVO) {
        ProfessorVO res = iProfessorDAO.updateOrSave(professorVO);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteProfessor (
            @PathVariable("id") int id)
    {
        Boolean res = iProfessorDAO.deleteByID(id);

        return new ResponseEntity<>(res ? "SUCCESS" : "FAILURE", HttpStatus.OK);
    }
}
