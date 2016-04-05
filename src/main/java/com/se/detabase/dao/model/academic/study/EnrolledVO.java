package com.se.detabase.dao.model.academic.study;

import java.io.Serializable;

/**
 * Created by Catalin on 03-Apr-16.
 */
public class EnrolledVO implements Serializable {

    private int studentId;

    private String courseId;

    public EnrolledVO(String courseId, int studentId) {
        this.courseId = courseId;
        this.studentId = studentId;
    }

    public int getStudentId() {
        return studentId;
    }

    public String getCourseId() {
        return courseId;
    }

    @Override
    public String toString() {
        return "EnrolledVO{" +
                "studentId=" + studentId +
                ", courseId=" + courseId +
                '}';
    }
}
