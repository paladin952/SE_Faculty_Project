package com.se.controller;


import com.se.database.dao.interfaces.IEvaluationDAO;
import com.se.database.dao.model.academic.course.EvaluationVO;
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
@RequestMapping("evaluation")
public class EvaluationController {

    @Autowired
    private IEvaluationDAO iEvaluationDAO;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<List<EvaluationVO>> getEvaluations() {
        List<EvaluationVO> evaluationVOList = iEvaluationDAO.list();
        return new ResponseEntity<>(evaluationVOList, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<EvaluationVO> getEvaluation(
            @PathVariable("id") int id) {
        EvaluationVO evaluationVO = iEvaluationDAO.getByID(id);
        return new ResponseEntity<>(evaluationVO, evaluationVO != null ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/add", method = RequestMethod.PUT)
    public ResponseEntity<EvaluationVO> updateEvaluation(
            @RequestBody EvaluationVO evaluationVO) {
        EvaluationVO res = iEvaluationDAO.updateOrSave(evaluationVO);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteEvaluation (
            @PathVariable("id") int id)
    {
        Boolean res = iEvaluationDAO.deleteByID(id);

        return new ResponseEntity<>(res ? "SUCCESS" : "FAILURE", HttpStatus.OK);
    }

}
