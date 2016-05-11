package com.se.controller;


import com.se.database.dao.interfaces.IDepartmentDAO;
import com.se.database.dao.model.academic.groups.DepartmentVO;
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
@RequestMapping("department")
public class DepartmentController {

    @Autowired
    private IDepartmentDAO iDepartmentDAO;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<List<DepartmentVO>> getDepartments () {
        List<DepartmentVO> departmentVOs = iDepartmentDAO.list();
        return new ResponseEntity<>(departmentVOs, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<DepartmentVO> getDepartment(
            @PathVariable("id") int id) {
        DepartmentVO departmentVO = iDepartmentDAO.getByID(id);
        return new ResponseEntity<>(departmentVO, departmentVO != null ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/add", method = RequestMethod.PUT)
    public ResponseEntity<DepartmentVO> updateDepartment(
            @RequestBody DepartmentVO departmentVO) {
        DepartmentVO res = iDepartmentDAO.updateOrSave(departmentVO);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteDepartment (
            @PathVariable("id") int id)
    {
        Boolean res = iDepartmentDAO.deleteByID(id);

        return new ResponseEntity<>(res ? "SUCCESS" : "FAILURE", HttpStatus.OK);
    }

}
