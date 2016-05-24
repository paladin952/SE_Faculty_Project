package com.se.database.dao.model.academic.study;

import com.se.database.dao.model.academic.course.EvaluationVO;
import com.se.database.dao.model.users.StudentVO;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "studentevaluation")
public class StudentEvaluationVO implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "StudentEvaluationID")
    private int id;

    @ManyToOne
    @JoinColumn(name = "EvaluationID")
    private EvaluationVO evaluationVO;

    @ManyToOne
    @JoinColumn(name = "StudentID")
    private StudentVO studentVO;

    @Column(name = "Grade")
    private float grade;

    @Column(name = "IsAbsent")
    private boolean isAbsent;

    public StudentEvaluationVO() {
    }

    public StudentEvaluationVO(EvaluationVO evaluationVO, StudentVO studentVO, float grade, boolean isAbsent) {
        this.evaluationVO = evaluationVO;
        this.studentVO = studentVO;
        this.grade = grade;
        this.isAbsent = isAbsent;
    }

    public int getId() {
        return id;
    }

    public EvaluationVO getEvaluationVO() {
        return evaluationVO;
    }

    public StudentVO getStudentVO() {
        return studentVO;
    }

    public float getGrade() {
        return grade;
    }

    public void setGrade(float grade) {
        this.grade = grade;
    }

    public boolean isAbsent() {
        return isAbsent;
    }

    public void setAbsent(boolean absent) {
        isAbsent = absent;
    }

    @Override
    public String toString() {
        return "StudentEvaluationVO { " +
                "evaluationVO = " + evaluationVO +
                ", studentVO = " + studentVO +
                " }";
    }
}
