package com.se.controller;

import com.se.database.dao.interfaces.ICourseDAO;
import com.se.database.dao.model.academic.course.CourseVO;
import com.se.database.dao.model.academic.course.activities.ActivityVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/course")
@CrossOrigin
public class CourseController {
    @Autowired
    private ICourseDAO iCourseDAO;

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<CourseVO> deleteCourse(@PathVariable(value = "id") String id) {
        Boolean res = iCourseDAO.deleteByID(id);
        return new ResponseEntity<>(res ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/add", method = RequestMethod.PUT)
    public ResponseEntity<CourseVO> updateCourse(@RequestBody CourseVO course) {
        System.out.println((course!= null)?course.toString():"null");
        CourseVO tmp = iCourseDAO.updateOrSave(course);
        return new ResponseEntity<>(tmp, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<CourseVO> getCourse(@PathVariable(value = "id") String id) {
        CourseVO course = iCourseDAO.getByID(id);
        return new ResponseEntity<>(course, course != null ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<List<CourseVO>> getCourses() {
        List<CourseVO> courses = iCourseDAO.list();
        return new ResponseEntity<>(courses, HttpStatus.OK);
    }

    @RequestMapping(value = "/get/{id}/activities", method = RequestMethod.GET)
    public ResponseEntity<List<ActivityVO>> getActivities(@PathVariable(value = "id") String id) {
        List<ActivityVO> activities = iCourseDAO.getActivitiesFor(id);

        return new ResponseEntity<>(activities, activities != null ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }
}
