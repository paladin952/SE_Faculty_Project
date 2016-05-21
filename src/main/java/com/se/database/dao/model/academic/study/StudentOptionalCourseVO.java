package com.se.database.dao.model.academic.study;

import com.se.database.dao.model.academic.course.CourseVO;
import com.se.database.dao.model.users.StudentVO;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "studentoptionalcourse")
public class StudentOptionalCourseVO implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "StudentOptionalCourseID")
    private int id;

    @ManyToOne
    @JoinColumn(name = "CourseID")
    private CourseVO courseVO;

    @ManyToOne
    @JoinColumn(name = "StudentID")
    private StudentVO studentVO;

    public StudentOptionalCourseVO() {
    }

    public StudentOptionalCourseVO(CourseVO courseVO, StudentVO studentVO) {
        this.courseVO = courseVO;
        this.studentVO = studentVO;
    }

    public int getId() {
        return id;
    }

    public CourseVO getCourseVO() {
        return courseVO;
    }

    public StudentVO getStudentVO() {
        return studentVO;
    }
}
