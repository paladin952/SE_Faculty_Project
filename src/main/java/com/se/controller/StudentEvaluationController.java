package com.se.controller;

import com.se.database.dao.interfaces.IStudentEvaluationDAO;
import com.se.database.dao.model.academic.study.StudentEvaluationVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("studentevaluation")
@CrossOrigin
public class StudentEvaluationController {
    @Autowired
    private IStudentEvaluationDAO iStudentEvaluationDAO;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<List<StudentEvaluationVO>> getStudentsEvaluations() {
        List<StudentEvaluationVO> studentEvaluationVOs = iStudentEvaluationDAO.list();
        return new ResponseEntity<>(studentEvaluationVOs, HttpStatus.OK);
    }

    @RequestMapping(value = "/add", method = RequestMethod.PUT)
    public ResponseEntity<StudentEvaluationVO> updateStudentEvaluation(@RequestBody StudentEvaluationVO studentEvaluationVO) {
        StudentEvaluationVO tmp = iStudentEvaluationDAO.updateOrSave(studentEvaluationVO);
        return new ResponseEntity<>(tmp, HttpStatus.OK);
    }

    @RequestMapping(value = "/{student_id}/{evaluation_id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteStudentEvaluation(@PathVariable(value = "student_id") int student_id, @PathVariable(value = "evaluation_id") int evaluation_id) {
        Boolean res = iStudentEvaluationDAO.deleteByIDs(student_id, evaluation_id);
        return new ResponseEntity<>(res ? "SUCCESS" : "FALURE", res ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/get/{student_id}", method = RequestMethod.GET)
    public ResponseEntity<List<StudentEvaluationVO>> getStudentEvaluation(@PathVariable(value = "student_id") int student_id) {
        List<StudentEvaluationVO> studentEvaluationVOs = iStudentEvaluationDAO.getStudentEvaluationsFor(student_id);
        return new ResponseEntity<>(studentEvaluationVOs, HttpStatus.OK);
    }

}
