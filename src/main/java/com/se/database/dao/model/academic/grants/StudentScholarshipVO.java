package com.se.database.dao.model.academic.grants;

import com.se.database.dao.model.users.StudentVO;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "studentscholarship")
public class StudentScholarshipVO implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "StudentScholarshipID")
    private int id;

    @OneToOne
    @JoinColumn(name = "ScholarshipID")
    public ScholarshipVO scholarshipVO;

    @OneToOne
    @JoinColumn(name = "StudentID")
    public StudentVO studentVO;

    public StudentScholarshipVO() {
    }

    public StudentScholarshipVO(ScholarshipVO scholarshipVO, StudentVO studentVO) {
        this.scholarshipVO = scholarshipVO;
        this.studentVO = studentVO;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ScholarshipVO getScholarshipVO() {
        return scholarshipVO;
    }

    public void setScholarshipVO(ScholarshipVO scholarshipVO) {
        this.scholarshipVO = scholarshipVO;
    }

    public StudentVO getStudentVO() {
        return studentVO;
    }

    public void setStudentVO(StudentVO studentVO) {
        this.studentVO = studentVO;
    }

    @Override
    public String toString() {
        return "StudentScholarshipVO{" +
                "id=" + id +
                ", scholarshipVO=" + scholarshipVO +
                ", studentVO=" + studentVO +
                '}';
    }
}
