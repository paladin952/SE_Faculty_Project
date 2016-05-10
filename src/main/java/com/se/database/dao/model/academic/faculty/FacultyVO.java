package com.se.database.dao.model.academic.faculty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Catalin on 03-Apr-16.
 */
@Entity
@Table(name = "faculty")
public class FacultyVO implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "FacultyID")
    private int facultyId;

    @Column(name = "Name")
    private String name;

    public FacultyVO() {
    }

    public FacultyVO(String name) {
        this.name = name;
    }

    public int getFacultyId() {
        return facultyId;
    }

    public void setFacultyId(int facultyId) {
        this.facultyId = facultyId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "FacultyVO{" +
                "facultyId=" + facultyId +
                ", name='" + name + '\'' +
                '}';
    }
/*
    private final String name;

    private List<DegreeVO> degrees;

    public FacultyVO(String name) {
        this.name = name;
    }

    public FacultyVO(String name, List<DegreeVO> degrees) {
        this.name = name;
        this.degrees = degrees;
    }

    public String getName() {
        return name;
    }

    public List<DegreeVO> getDegrees() {
        return degrees;
    }

    public void setDegrees(List<DegreeVO> degrees) {
        this.degrees = degrees;
    }

    @Override
    public String toString() {
        return "Faculty{" +
                "name='" + name + '\'' +
                ", degrees=" + degrees +
                '}';
    }
    */
}
