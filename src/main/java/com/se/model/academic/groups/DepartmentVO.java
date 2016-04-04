package com.se.model.academic.groups;

import java.io.Serializable;

/**
 * Created by Catalin on 03-Apr-16.
 */
public class DepartmentVO implements Serializable {

    private String name;

    private List<ProfessorVo> professors;

    public DepartmentVO() {
    }

    public DepartmentVO(String name, List<ProfessorVo> professors) {
        this.name = name;
        this.professors = professors;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ProfessorVo> getProfessors() {
        return professors;
    }

    public void setProfessors(List<ProfessorVo> professors) {
        this.professors = professors;
    }

    @Override
    public String toString() {
        return "DepartmentVO{" +
                "name='" + name + '\'' +
                ", professors=" + professors +
                '}';
    }
}
