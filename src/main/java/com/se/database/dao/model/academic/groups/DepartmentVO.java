package com.se.database.dao.model.academic.groups;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.se.database.dao.model.users.ProfessorVO;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "department")
public class DepartmentVO implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "DepartmentID")
    private int id;

    @Column(name = "Name")
    private String name;

    @JsonIgnore
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "departmentVO")
    private Set<ProfessorVO> professors = new HashSet<>();

    public DepartmentVO() {
    }

    public DepartmentVO(String name) {
        this.name = name;
    }

    public DepartmentVO(String name, Set<ProfessorVO> professors) {
        this.name = name;
        this.professors = professors;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<ProfessorVO> getProfessors() {
        return professors;
    }

    public void setProfessors(Set<ProfessorVO> professors) {
        this.professors = professors;
    }

    public int getId() {
        return id;
    }

    public void setId(int departmentId) {
        this.id = departmentId;
    }

    @Override
    public String toString() {
        return "DepartmentVO{" +
                "name='" + name + '\'' +
                ", professors=" + professors +
                '}';
    }
}
