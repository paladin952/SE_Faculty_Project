package com.se.model.academic.study;

import java.io.Serializable;

/**
 * Created by Catalin on 03-Apr-16.
 */
public class StudentOptionalCourseVO implements Serializable {

    private String courseId;

    private int studentId;

    public StudentOptionalCourseVO(String courseId, int studentId) {
        this.courseId = courseId;
        this.studentId = studentId;
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
