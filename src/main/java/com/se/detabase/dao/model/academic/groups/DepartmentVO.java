package com.se.detabase.dao.model.academic.groups;

import com.se.detabase.dao.model.users.ProfessorVO;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Catalin on 03-Apr-16.
 */
public class DepartmentVO implements Serializable {

    private String name;

    private List<ProfessorVO> professors;

    public DepartmentVO() {
    }

    public DepartmentVO(String name, List<ProfessorVO> professors) {
        this.name = name;
        this.professors = professors;
    }

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

    @Override
    public String toString() {
        return "DepartmentVO{" +
                "name='" + name + '\'' +
                ", professors=" + professors +
                '}';
    }
}
