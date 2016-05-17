package com.se.controller;

import com.se.database.dao.interfaces.IPersonDAO;
import com.se.database.dao.model.users.PersonVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/person")
@CrossOrigin
public class PersonController {

    @Autowired
    private IPersonDAO iPersonDAO;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<List<PersonVO>> getPersons() {
        List<PersonVO> persons = iPersonDAO.list();
        return new ResponseEntity<>(persons, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<PersonVO> getPerson(
            @PathVariable("id") int id) {
        PersonVO person = iPersonDAO.getByID(id);
        return new ResponseEntity<>(person, person != null ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/add", method = RequestMethod.PUT)
    public ResponseEntity<PersonVO> updatePerson(
            @RequestBody PersonVO person) {
        PersonVO tmp = iPersonDAO.getByID(person.getId());
        if (tmp != null)
            person.setUserVO(tmp.getUserVO());
        PersonVO res = iPersonDAO.updateOrSave(person);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deletePerson (
            @PathVariable("id") int id)
    {
        Boolean res = iPersonDAO.deleteByID(id);

        return new ResponseEntity<>(res ? "SUCCESS" : "FAILURE", HttpStatus.OK);
    }

}
