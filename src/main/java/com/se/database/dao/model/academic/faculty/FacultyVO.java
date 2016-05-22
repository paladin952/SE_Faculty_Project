package com.se.database.dao.model.academic.faculty;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "faculty")
public class FacultyVO implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "FacultyID")
    private int id;

    @Column(name = "Name")
    private String name;

    @JsonIgnore
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "faculty")
    private List<DegreeVO> degrees;

    public FacultyVO() {
    }

    public FacultyVO(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public FacultyVO setName(String name) {
        this.name = name;

        return this;
    }

    public String getName() {
        return name;
    }

    public List<DegreeVO> getDegrees() {
        return degrees;
    }

    public FacultyVO setDegrees(List<DegreeVO> degrees) {
        this.degrees = degrees;

        return this;
    }

    @Override
    public String toString() {
        return "Faculty{" +
                "name='" + name + '\'' +
                '}';
    }
}
