package com.se.controller;

import com.se.database.dao.interfaces.*;
import com.se.database.dao.model.academic.course.EvaluationVO;
import com.se.database.dao.model.academic.course.OptionalCourseVO;
import com.se.database.dao.model.academic.groups.DepartmentVO;
import com.se.database.dao.model.users.PersonVO;
import com.se.database.dao.model.users.ProfessorVO;
import com.se.database.dao.model.users.StudentVO;
import com.se.database.dao.model.users.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;


@Controller("/")
public class MainRestController {

    @Autowired
    private IProfessorDAO iProfessorDAO;

//    @Autowired
//    private IOptionalCourseDAO iOptionalCourseDAO;

    @RequestMapping("/")
    public ResponseEntity<String> home(){
        return new ResponseEntity<>("Welcome!!!", HttpStatus.OK);
    }

//    @RequestMapping(value = "/professors", method = RequestMethod.GET)
//    public ResponseEntity<List<ProfessorVO>> getProfessors () {
//        List<ProfessorVO> professors = iProfessorDAO.list();
//        return new ResponseEntity<>(professors, HttpStatus.OK);
//    }
//
//    @RequestMapping(value = "/professor/{id}", method = RequestMethod.GET)
//    public ResponseEntity<ProfessorVO> getProfessor(
//            @PathVariable("id") int id) {
//        ProfessorVO professorVO = iProfessorDAO.getByID(id);
//        return new ResponseEntity<>(professorVO, professorVO != null ? HttpStatus.OK : HttpStatus.NOT_FOUND);
//    }
//
//    @RequestMapping(value = "/professor", method = RequestMethod.PUT)
//    public ResponseEntity<ProfessorVO> updateProfessor(
//            @RequestBody ProfessorVO professorVO) {
//        ProfessorVO res = iProfessorDAO.updateOrSave(professorVO);
//        return new ResponseEntity<>(res, HttpStatus.OK);
//    }
//
//    @RequestMapping(value = "/professor/{id}", method = RequestMethod.DELETE)
//    public ResponseEntity<String> deleteProfessor (
//            @PathVariable("id") int id)
//    {
//        Boolean res = iProfessorDAO.deleteByID(id);
//
//        return new ResponseEntity<>(res ? "SUCCESS" : "FAILURE", HttpStatus.OK);
//    }


//    @RequestMapping(value = "/optionalCourses", method = RequestMethod.GET)
//    public ResponseEntity<List<OptionalCourseVO>> getOptionalCourses() {
//        List<OptionalCourseVO> optionalCourseVOs = iOptionalCourseDAO.list();
//        return new ResponseEntity<>(optionalCourseVOs, HttpStatus.OK);
//    }
//
//    @RequestMapping(value = "/optionalCourse/{id}", method = RequestMethod.GET)
//    public ResponseEntity<OptionalCourseVO> getOptionalCourse(
//            @PathVariable("id") int id) {
//        OptionalCourseVO optionalCourseVO = iOptionalCourseDAO.getByID(id);
//        return new ResponseEntity<>(optionalCourseVO, optionalCourseVO != null ? HttpStatus.OK : HttpStatus.NOT_FOUND);
//    }
//
//    @RequestMapping(value = "/optionalCourse", method = RequestMethod.PUT)
//    public ResponseEntity<OptionalCourseVO> updateOptionalCourse(
//            @RequestBody OptionalCourseVO optionalCourseVO) {
//        OptionalCourseVO res = iOptionalCourseDAO.updateOrSave(optionalCourseVO);
//        return new ResponseEntity<>(res, HttpStatus.OK);
//    }
//
//    @RequestMapping(value = "/optionalCourse/{id}", method = RequestMethod.DELETE)
//    public ResponseEntity<String> deleteOptionalCourse (
//            @PathVariable("id") int id)
//    {
//        Boolean res = iOptionalCourseDAO.deleteByID(id);
//
//        return new ResponseEntity<>(res ? "SUCCESS" : "FAILURE", HttpStatus.OK);
//    }


}

