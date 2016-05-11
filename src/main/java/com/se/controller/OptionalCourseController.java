package com.se.controller;


import com.se.database.dao.interfaces.IOptionalCourseDAO;
import com.se.database.dao.model.academic.course.OptionalCourseVO;
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
@RequestMapping("/optionalcourse")
public class OptionalCourseController {

    @Autowired
    private IOptionalCourseDAO iOptionalCourseDAO;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<List<OptionalCourseVO>> getOptionalCourses() {
        List<OptionalCourseVO> optionalCourseVOs = iOptionalCourseDAO.list();
        return new ResponseEntity<>(optionalCourseVOs, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<OptionalCourseVO> getOptionalCourse(
            @PathVariable("id") int id) {
        OptionalCourseVO optionalCourseVO = iOptionalCourseDAO.getByID(id);
        return new ResponseEntity<>(optionalCourseVO, optionalCourseVO != null ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/add", method = RequestMethod.PUT)
    public ResponseEntity<OptionalCourseVO> updateOptionalCourse(
            @RequestBody OptionalCourseVO optionalCourseVO) {
        OptionalCourseVO res = iOptionalCourseDAO.updateOrSave(optionalCourseVO);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteOptionalCourse(
            @PathVariable("id") int id) {
        Boolean res = iOptionalCourseDAO.deleteByID(id);

        return new ResponseEntity<>(res ? "SUCCESS" : "FAILURE", HttpStatus.OK);
    }


}
