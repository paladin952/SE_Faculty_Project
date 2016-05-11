package com.se.database.dao.model.academic.course;

import com.se.util.enums.ExamTypesEnum;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Catalin on 03-Apr-16.
 */
@Entity
@Table(name = "evaluation")
public class EvaluationVO implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "EvaluationID")
    private int id;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "EvaluationType")
    private ExamTypesEnum type;

//    @Column(name = )
// FIXME: 10.05.2016
    //check db
//    @Column(insertable = "Grade")
//    private float grade;

    // FIXME: 10.05.2016
//    @Column(name = "IsAbsent")
//    private Boolean isAbsent;

    public EvaluationVO() {
    }

    public EvaluationVO(int id) {
        this.id = id;
    }

    public EvaluationVO(ExamTypesEnum type) {
        this.type = type;
    }

    public EvaluationVO(ExamTypesEnum type, float grade, Boolean isAbsent) {
        this.type = type;
//        this.grade = grade;
//        this.isAbsent = isAbsent;
    }

    public EvaluationVO(int id, ExamTypesEnum type, float grade, Boolean isAbsent) {
        this.id = id;
        this.type = type;
//        this.grade = grade;
//        this.isAbsent = isAbsent;
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

//    public float getGrade() {
//        return grade;
//    }
//
//    public void setGrade(float grade) {
//        this.grade = grade;
//    }
//
//    public Boolean isAbsent() {
//        return isAbsent;
//    }
//
//    public void setIsAbsent(Boolean absent) {
//        isAbsent = absent;
//    }

    @Override
    public String toString() {
        return "EvaluationVO{" +
                "id=" + id +
                ", type=" + type +
//                ", grade=" + grade +
//                ", isAbsent=" + isAbsent +
                '}';
    }
}
