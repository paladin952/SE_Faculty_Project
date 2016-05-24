package com.se.controller;

import com.se.database.dao.interfaces.IDegreeDAO;
import com.se.database.dao.model.academic.faculty.DegreeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by dana on 5/22/2016.
 */
@Controller
@RequestMapping("/degree")
@CrossOrigin
public class DegreeController {
    @Autowired
    private IDegreeDAO iDegreeDAO;

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<DegreeVO> deleteDegree(@PathVariable(value = "id") int id) {
        Boolean res = iDegreeDAO.deleteByID(id);
        return new ResponseEntity<>(res ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/add", method = RequestMethod.PUT)
    public ResponseEntity<DegreeVO> updateDegree(@RequestBody DegreeVO degree) {
        DegreeVO tmp = iDegreeDAO.updateOrSave(degree);
        return new ResponseEntity<>(tmp, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<DegreeVO> getDegree(@PathVariable(value = "id") int id) {
        DegreeVO degree = iDegreeDAO.getByID(id);
        return new ResponseEntity<>(degree, degree != null ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<List<DegreeVO>> getActivities() {
        List<DegreeVO> degrees = iDegreeDAO.list();
        return new ResponseEntity<>(degrees, HttpStatus.OK);
    }
}
