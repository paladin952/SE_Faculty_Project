package com.se.database.dao.model.academic.faculty;

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

    @Override
    public String toString() {
        return "Faculty{" +
                "name='" + name + '\'' +
                '}';
    }
}
