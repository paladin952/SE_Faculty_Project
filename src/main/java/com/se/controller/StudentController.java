package com.se.controller;

import com.se.database.dao.interfaces.IStudentDAO;
import com.se.database.dao.model.users.StudentVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/student")
@CrossOrigin
public class StudentController {

    @Autowired
    private IStudentDAO iStudentDAO;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<List<StudentVO>> getStudents() {
        List<StudentVO> students = iStudentDAO.list();

        HttpHeaders httpHeaders = new HttpHeaders();

        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<StudentVO> getStudent(@PathVariable("id") int id) {
        StudentVO student = iStudentDAO.getByID(id);

        return new ResponseEntity<>(student, student != null ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/add", method = RequestMethod.PUT)
    public ResponseEntity<StudentVO> updateStudent(
            @RequestBody StudentVO student) {
        StudentVO tmp = iStudentDAO.getByID(student.getId());
        if (tmp != null)
            student.setPersonVO(tmp.getPersonVO());
        StudentVO res = iStudentDAO.updateOrSave(student);

        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteStudent(
            @PathVariable("id") int id)
    {
        Boolean res = iStudentDAO.deleteByID(id);
        if(res){
            System.out.println("Delete success");
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            System.out.println("Delete failure");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
