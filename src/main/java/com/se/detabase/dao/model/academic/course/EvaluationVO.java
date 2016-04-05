package com.se.detabase.dao.model.academic.course;

import com.se.util.enums.ExamTypesEnum;

import java.io.Serializable;

/**
 * Created by Catalin on 03-Apr-16.
 */
public class EvaluationVO implements Serializable {

    private int id;

    private ExamTypesEnum type;

    private float grade;

    private Boolean isAbsent;

    public EvaluationVO(int id) {
        this.id = id;
    }

    public EvaluationVO(int id, ExamTypesEnum type, float grade, Boolean isAbsent) {
        this.id = id;
        this.type = type;
        this.grade = grade;
        this.isAbsent = isAbsent;
    }

    public int getId() {
        return id;
    }

    public ExamTypesEnum getType() {
        return type;
    }

    public void setType(ExamTypesEnum type) {
        this.type = type;
    }

    public float getGrade() {
        return grade;
    }

    public void setGrade(float grade) {
        this.grade = grade;
    }

    public Boolean isAbsent() {
        return isAbsent;
    }

    public void setIsAbsent(Boolean absent) {
        isAbsent = absent;
    }

    @Override
    public String toString() {
        return "EvaluationVO{" +
                "id=" + id +
                ", type=" + type +
                ", grade=" + grade +
                ", isAbsent=" + isAbsent +
                '}';
    }
}
