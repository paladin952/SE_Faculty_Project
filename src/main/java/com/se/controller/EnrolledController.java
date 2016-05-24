package com.se.controller;

import com.se.database.dao.interfaces.IEnrolledDAO;
import com.se.database.dao.model.academic.course.CourseVO;
import com.se.database.dao.model.academic.study.EnrolledVO;
import com.se.database.dao.model.users.StudentVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/enrolled")
@CrossOrigin
public class EnrolledController {
    @Autowired
    private IEnrolledDAO iEnrolledDAO;

    @RequestMapping(value = "/add", method = RequestMethod.PUT)
    public ResponseEntity<EnrolledVO> addEnrolled(@RequestBody EnrolledVO enrolledVO) {
        EnrolledVO enrolled = iEnrolledDAO.save(enrolledVO);
        return new ResponseEntity<>(enrolled, HttpStatus.OK);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<List<EnrolledVO>> getEnrolledList() {
        List<EnrolledVO> enrolled_list = iEnrolledDAO.list();
        return new ResponseEntity<>(enrolled_list, HttpStatus.OK);
    }

    @RequestMapping(value = "/{student_id}/{course_id}", method = RequestMethod.DELETE)
    public ResponseEntity<EnrolledVO> deleteEnrolled(@PathVariable(value = "student_id") int student_id, @PathVariable(value = "course_id") String course_id) {
        Boolean res = iEnrolledDAO.deleteByIDs(student_id, course_id);
        return new ResponseEntity<>(res ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/get/{student_id}/courses", method = RequestMethod.GET)
    public ResponseEntity<List<CourseVO>> getStudentCourses(@PathVariable(value = "student_id") int student_id) {
        List<CourseVO> courses = iEnrolledDAO.getEnrolledCoursesForStudent(student_id);

        return new ResponseEntity<>(courses, HttpStatus.OK);
    }

    @RequestMapping(value = "/get/{course_id/students", method = RequestMethod.GET)
    public ResponseEntity<List<StudentVO>> getCourseStudents(@PathVariable(value = "course_id") String course_id) {
        List<StudentVO> students = iEnrolledDAO.getEnrolledStudentsForCourse(course_id);

        return new ResponseEntity<>(students, HttpStatus.OK);
    }
}
