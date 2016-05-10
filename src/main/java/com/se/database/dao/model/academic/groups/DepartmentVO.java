package com.se.database.dao.model.academic.groups;

import com.se.database.dao.model.users.ProfessorVO;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "department")
public class DepartmentVO implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "DepartmentID")
    private int departmentId;

    @Column(name = "Name")
    private String name;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "departmentVO")
    private List<ProfessorVO> professors;

    public DepartmentVO() {
    }

    public DepartmentVO(String name) {
        this.name = name;
    }

    public DepartmentVO(String name, List<ProfessorVO> professors) {
        this.name = name;
        this.professors = professors;
    }

//    public DepartmentVO(int departmentId, String name, List<ProfessorVO> professors) {
//        this.departmentId = departmentId;
//        this.name = name;
//        this.professors = professors;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ProfessorVO> getProfessors() {
        return professors;
    }

    public void setProfessors(List<ProfessorVO> professors) {
        this.professors = professors;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    @Override
    public String toString() {
        return "DepartmentVO{" +
                "name='" + name + '\'' +
                ", professors=" + professors +
                '}';
    }
}
