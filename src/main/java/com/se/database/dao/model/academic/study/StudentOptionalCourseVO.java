package com.se.database.dao.model.academic.study;

import java.io.Serializable;

/**
 * Created by Catalin on 03-Apr-16.
 */
public class StudentOptionalCourseVO implements Serializable {

    private int id;

    private String courseId;

    private int studentId;

    public StudentOptionalCourseVO(String courseId, int studentId) {
        this.courseId = courseId;
        this.studentId = studentId;
    }

    public int getId() {
        return id;
    }

    public String getCourseId() {
        return courseId;
    }

    public int getStudentId() {
        return studentId;
    }

    @Override
    public String toString() {
        return "StudentOptionalCourseVO{" +
                "courseId='" + courseId + '\'' +
                ", studentId=" + studentId +
                '}';
    }
}
