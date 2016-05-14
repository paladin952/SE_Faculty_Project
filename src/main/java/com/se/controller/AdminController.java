package com.se.controller;

import com.se.database.dao.interfaces.IAdminDAO;
import com.se.database.dao.model.users.AdminVO;
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
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private IAdminDAO iAdminDAO;

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteAdmin(@PathVariable(value = "id") int id) {
        Boolean res = iAdminDAO.deleteByID(id);
        return new ResponseEntity<>(res ? "SUCCESS" : "FAILURE", res ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/add", method = RequestMethod.PUT)
    public ResponseEntity<AdminVO> updateAdmin(@RequestBody AdminVO admin) {
        AdminVO tmp = iAdminDAO.updateOrSave(admin);
        return new ResponseEntity<>(tmp, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<AdminVO> getAdmin(@PathVariable(value = "id") int id) {
        AdminVO adminVO = iAdminDAO.getByID(id);
        return new ResponseEntity<>(adminVO, adminVO != null ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<List<AdminVO>> getAdmins() {
        List<AdminVO> admins = iAdminDAO.list();
        return new ResponseEntity<>(admins, HttpStatus.OK);
    }
}
