package com.se.controller;

import com.se.database.dao.interfaces.IFacultyDAO;
import com.se.database.dao.model.academic.faculty.DegreeVO;
import com.se.database.dao.model.academic.faculty.FacultyVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/faculty")
@CrossOrigin
public class FacultyController {
    @Autowired
    private IFacultyDAO iFacultyDAO;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<List<FacultyVO>> getFaculties() {
        List<FacultyVO> faculties = iFacultyDAO.list();
        return new ResponseEntity<>(faculties, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<FacultyVO> getFaculty(
            @PathVariable(value = "id") int id) {
        FacultyVO faculty = iFacultyDAO.getByID(id);
        return new ResponseEntity<>(faculty, faculty != null ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/get/{id}/degrees", method = RequestMethod.GET)
    public ResponseEntity<List<DegreeVO>> getFacultyDegrees(
            @PathVariable(value = "id") int id) {
        List<DegreeVO> degrees = iFacultyDAO.getDegreesFor(id);

        return new ResponseEntity<>(degrees, degrees != null ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }
}
