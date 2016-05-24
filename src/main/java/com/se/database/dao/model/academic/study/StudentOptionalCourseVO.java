package com.se.database.dao.model.academic.study;

import com.se.database.dao.model.academic.course.OptionalCourseVO;
import com.se.database.dao.model.academic.course.OptionalCourseVO;
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
    @JoinColumn(name = "OptionalCourseID")
    private OptionalCourseVO optionalCourseVO;

    @ManyToOne
    @JoinColumn(name = "StudentID")
    private StudentVO studentVO;

    public StudentOptionalCourseVO() {
    }

    public StudentOptionalCourseVO(OptionalCourseVO optionalCourseVO, StudentVO studentVO) {
        this.optionalCourseVO = optionalCourseVO;
        this.studentVO = studentVO;
    }

    public int getId() {
        return id;
    }

    public OptionalCourseVO getOptionalCourseVO() {
        return optionalCourseVO;
    }

    public StudentVO getStudentVO() {
        return studentVO;
    }

    @Override
    public String toString() {
        return "StudentOptionalCourseVO { " +
                "id = " + id +
                ", optionalCourseVO = " + optionalCourseVO +
                ", studentVO = " + studentVO +
                " }";
    }
}
