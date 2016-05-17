package com.se.controller;

import com.se.database.dao.interfaces.IStudentGroupDAO;
import com.se.database.dao.model.academic.groups.StudentGroupVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/studentgroup")
@CrossOrigin
public class StudentGroupController {
    @Autowired
    private IStudentGroupDAO iStudentGroupDAO;

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteStudentGroup(@PathVariable(value = "id") int id) {
        Boolean res = iStudentGroupDAO.deleteByID(id);
        return new ResponseEntity<>(res ? "SUCCESS" : "FAILURE", res ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/add", method = RequestMethod.PUT)
    public ResponseEntity<StudentGroupVO> updateStudentGroup(@RequestBody StudentGroupVO student_group) {
        StudentGroupVO tmp = iStudentGroupDAO.updateOrSave(student_group);
        return new ResponseEntity<>(tmp, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<StudentGroupVO> getStudentGroup(@PathVariable(value = "id") int id) {
        StudentGroupVO studentGroupVO = iStudentGroupDAO.getByID(id);
        return new ResponseEntity<>(studentGroupVO, studentGroupVO != null ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<List<StudentGroupVO>> getStudentGroups() {
        List<StudentGroupVO> studentGroupVOs = iStudentGroupDAO.list();
        return new ResponseEntity<>(studentGroupVOs, HttpStatus.OK);
    }
}
