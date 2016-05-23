package com.se.database.dao.model.academic.study;

import com.se.database.dao.model.academic.course.CourseVO;
import com.se.database.dao.model.users.StudentVO;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Enrolled")
public class EnrolledVO implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "EnrolledID")
    private int id;

    @OneToOne
    @JoinColumn(name = "StudentID")
    private StudentVO student;

    @OneToOne
    @JoinColumn(name = "CourseID")
    private CourseVO course;

    public EnrolledVO() {
    }

    public EnrolledVO(StudentVO student, CourseVO course) {
        this.student = student;
        this.course = course;
    }

    public int getId() {
        return id;
    }

    public CourseVO getCourse() {
        return course;
    }

    public EnrolledVO setCourse(CourseVO course) {
        this.course = course;

        return this;
    }

    public StudentVO getStudent() {
        return student;
    }

    public EnrolledVO setStudent(StudentVO student) {
        this.student = student;

        return this;
    }

    @Override
    public String toString() {
        return "EnrolledVO{" +
                "id=" + id +
                ", student=" + student +
                ", course=" + course +
                '}';
    }
}