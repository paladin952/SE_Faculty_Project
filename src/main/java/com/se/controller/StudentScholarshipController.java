package com.se.controller;


import com.se.database.dao.interfaces.IStudentScholarshipDAO;
import com.se.database.dao.model.academic.grants.ScholarshipVO;
import com.se.database.dao.model.academic.grants.StudentScholarshipVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/studentscholarship")
@CrossOrigin
public class StudentScholarshipController {

    @Autowired
    private IStudentScholarshipDAO iStudentScholarshipDAO;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<List<StudentScholarshipVO>> getStudents() {
        List<StudentScholarshipVO> students = iStudentScholarshipDAO.list();
        System.out.println("students = " + students);
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @RequestMapping(value = "/get/scholarship/{student_id}", method = RequestMethod.GET)
    public ResponseEntity<List<ScholarshipVO>> getScholarships(@PathVariable(value = "student_id") int student_id) {
        List<ScholarshipVO> scholarshipVOs = iStudentScholarshipDAO.getScholarshipsForStudent(student_id);
        return new ResponseEntity<>(scholarshipVOs, HttpStatus.OK);
    }

    @RequestMapping(value = "/get/{student_id}", method = RequestMethod.GET)
    public ResponseEntity<List<StudentScholarshipVO>> getStudentScholarships(@PathVariable(value = "student_id") int student_id) {
        List<StudentScholarshipVO> studentScholarshipVOs = iStudentScholarshipDAO.getStudentScholarshipsForStudent(student_id);
        return new ResponseEntity<>(studentScholarshipVOs, HttpStatus.OK);
    }

    @RequestMapping(value = "/add", method = RequestMethod.PUT)
    public ResponseEntity<StudentScholarshipVO> updateStudentEvaluation(@RequestBody StudentScholarshipVO studentScholarshipVO) {
        StudentScholarshipVO tmp = iStudentScholarshipDAO.updateOrSave(studentScholarshipVO);
        return new ResponseEntity<>(tmp, HttpStatus.OK);
    }

    @RequestMapping(value = "/{student_id}/{scholarship_id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteStudentScholarshipByIds(@PathVariable(value = "student_id") int student_id, @PathVariable(value = "scholarship_id") int scholarship_id) {
        Boolean res = iStudentScholarshipDAO.deleteScholarshipForStudent(scholarship_id, student_id);
        return new ResponseEntity<>(res ? "SUCCESS" : "FALURE", res ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/{studentScholarship_id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteStudentScholarship(@PathVariable(value = "studentScholarship_id") int studentScholarship_id) {
        Boolean res = iStudentScholarshipDAO.deleteById(studentScholarship_id);
        return new ResponseEntity<>(res ? "SUCCESS" : "FALURE", res ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }


}
