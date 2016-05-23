package com.se.controller;

import com.se.database.dao.interfaces.IStudentOptionalCourseDAO;
import com.se.database.dao.model.academic.course.OptionalCourseVO;
import com.se.database.dao.model.academic.study.StudentEvaluationVO;
import com.se.database.dao.model.academic.study.StudentOptionalCourseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/studentoptionalcourse")
@CrossOrigin
public class StudentOptionalCourseController {
    @Autowired
    private IStudentOptionalCourseDAO iStudentOptionalCourseDAO;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<List<StudentOptionalCourseVO>> getStudentOptionalCourses() {
        List<StudentOptionalCourseVO> student_optional_courses = iStudentOptionalCourseDAO.list();

        return new ResponseEntity<>(student_optional_courses, HttpStatus.OK);
    }

    @RequestMapping(value = "/{student_id}/{optional_course_id}", method = RequestMethod.DELETE)
    public ResponseEntity<StudentEvaluationVO> deleteOptionalCourseForStudent(@PathVariable(value = "student_id") int student_id, @PathVariable(value = "optional_course_id") String optional_course_id) {
        Boolean res = iStudentOptionalCourseDAO.deleteByIDs(student_id, optional_course_id);
        return new ResponseEntity<>(res ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/get/{student_id}", method = RequestMethod.GET)
    public ResponseEntity<List<OptionalCourseVO>> getStudentOptionalCourses(@PathVariable(value = "student_id") int student_id) {
        List<OptionalCourseVO> courses = iStudentOptionalCourseDAO.getStudentOptionalCoursesFor(student_id);

        return new ResponseEntity<>(courses, HttpStatus.OK);
    }

    @RequestMapping(value = "/get/{student_id}/{optional_course_group}", method = RequestMethod.GET)
    public ResponseEntity<List<OptionalCourseVO>> GetStudentOptionalCourseGroup(@PathVariable(value = "student_id") int student_id, @PathVariable(value = "optional_course_group") int optional_course_group) {
        List<OptionalCourseVO> courses = iStudentOptionalCourseDAO.getStudentOptionalCoursesByGroupFor(student_id, optional_course_group);

        return new ResponseEntity<>(courses, HttpStatus.OK);
    }
}
