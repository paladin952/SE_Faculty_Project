package com.se.controller;

import com.se.database.dao.interfaces.IActivityDAO;
import com.se.database.dao.model.academic.course.activities.ActivityVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/activity")
@CrossOrigin
public class ActivityController {
    @Autowired
    private IActivityDAO iActivityDAO;

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<ActivityVO> deleteActivity(@PathVariable(value = "id") int id) {
        Boolean res = iActivityDAO.deleteByID(id);
        return new ResponseEntity<>(res ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/add", method = RequestMethod.PUT)
    public ResponseEntity<ActivityVO> updateActivity(@RequestBody ActivityVO activity) {
        ActivityVO tmp = iActivityDAO.updateOrSave(activity);
        return new ResponseEntity<>(tmp, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<ActivityVO> getActivity(@PathVariable(value = "id") int id) {
        ActivityVO activity = iActivityDAO.getByID(id);
        return new ResponseEntity<>(activity, activity != null ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<List<ActivityVO>> getActivities() {
        List<ActivityVO> activities = iActivityDAO.list();
        return new ResponseEntity<>(activities, HttpStatus.OK);
    }
}
