package com.se.database.dao.model.academic.grants;

import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.io.Serializable;

public class StudentScholarshipVO implements Serializable {

    @OneToOne
    @JoinColumn(name = "ScholarshipID")
    public int scholarshipId;

    @OneToOne
    @JoinColumn(name = "StudentID")
    public int studentId;

    public StudentScholarshipVO(int studentId, int scholarshipId) {
        this.studentId = studentId;
        this.scholarshipId = scholarshipId;
    }

    public int getScholarshipId() {
        return scholarshipId;
    }

    public int getStudentId() {
        return studentId;
    }

    @Override
    public String toString() {
        return "StudentScholarshipVO{" +
                "scholarshipId=" + scholarshipId +
                ", studentId=" + studentId +
                '}';
    }
}
