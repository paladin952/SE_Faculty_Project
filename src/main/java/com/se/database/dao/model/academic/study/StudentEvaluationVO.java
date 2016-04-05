package com.se.database.dao.model.academic.study;

import java.io.Serializable;

/**
 * Created by Catalin on 03-Apr-16.
 */
public class StudentEvaluationVO implements Serializable {

    private int evaluationId;

    private int studentId;

    public StudentEvaluationVO(int evaluationId, int studentId) {
        this.evaluationId = evaluationId;
        this.studentId = studentId;
    }

    public int getEvaluationId() {
        return evaluationId;
    }

    public int getStudentId() {
        return studentId;
    }

    @Override
    public String toString() {
        return "StudentEvaluationVO{" +
                "evaluationId=" + evaluationId +
                ", studentId=" + studentId +
                '}';
    }
}
