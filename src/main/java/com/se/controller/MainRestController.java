package com.se.controller;

import com.se.database.dao.interfaces.IPersonDAO;
import com.se.database.dao.interfaces.IProfessorDAO;
import com.se.database.dao.interfaces.IStudentDAO;
import com.se.database.dao.interfaces.IUserDAO;
import com.se.database.dao.model.users.PersonVO;
import com.se.database.dao.model.users.ProfessorVO;
import com.se.database.dao.model.users.StudentVO;
import com.se.database.dao.model.users.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;



@Controller("/")
public class MainRestController {
    @Autowired
    private IUserDAO iUserDAO;

    @Autowired
    private IPersonDAO iPersonDAO;

    @Autowired
    private IStudentDAO iStudentDAO;

    @Autowired
    private IProfessorDAO iProfessorDAO;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<List<UserVO>> home() {
        List<UserVO> users = iUserDAO.list();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @RequestMapping(value = "/persons", method = RequestMethod.GET)
    public ResponseEntity<List<PersonVO>> getPersons() {
        List<PersonVO> persons = iPersonDAO.list();
        return new ResponseEntity<>(persons, HttpStatus.OK);
    }

    @RequestMapping(value = "/person/{id}", method = RequestMethod.GET)
    public ResponseEntity<PersonVO> getPerson(
            @PathVariable("id") int id) {
        PersonVO person = iPersonDAO.getByID(id);
        return new ResponseEntity<>(person, person != null ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

//    @RequestMapping(value = "/person/{PersonID}/{FirstName}/{LastName}/{DoB}/{SSN}/{Address}/{PhoneNo}/{UserID}", method = RequestMethod.PUT)
//    public ResponseEntity<PersonVO> updatePerson(
//            @PathVariable("PersonID") int id,
//            @PathVariable("FirstName") String firstName,
//            @PathVariable("LastName") String lastName,
//            @PathVariable("DoB") @DateTimeFormat(iso= DateTimeFormat.ISO.DATE) Date dob,
//            @PathVariable("SSN") long ssn,
//            @PathVariable("Address") String address,
//            @PathVariable("PhoneNo") int phoneNo,
//            @PathVariable("UserID") int userID) {
//        UserVO user = iUserDAO.getByID(userID);
//        PersonVO res = iPersonDAO.updateOrSave(id, firstName, lastName, dob, ssn, address, phoneNo, user);
//        return new ResponseEntity<>(res, HttpStatus.OK);
//    }

    @RequestMapping(value = "/person/{id}", method = RequestMethod.PUT)
    public ResponseEntity<String> deletePerson(
            @PathVariable("id") int id)
    {
        Boolean res = iPersonDAO.deleteByID(id);

        return new ResponseEntity<>(res ? "SUCCESS" : "FAILURE", HttpStatus.OK);
    }

    @RequestMapping(value = "/students", method = RequestMethod.GET)
    public ResponseEntity<List<StudentVO>> getStudents() {
        List<StudentVO> students = iStudentDAO.list();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @RequestMapping(value = "/professors", method = RequestMethod.GET)
    public ResponseEntity<List<ProfessorVO>> getProfessors() {
        List<ProfessorVO> professors = iProfessorDAO.list();
        return new ResponseEntity<>(professors, HttpStatus.OK);
    }
}

