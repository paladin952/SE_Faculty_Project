package com.se.database.dao.model.users;

import com.se.database.dao.model.academic.groups.DepartmentVO;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Professor database entity. Any ProfessorVO is a PersonVO.
 */
@Entity
@Table(name = "professor")
public class ProfessorVO implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "ProfessorID")
    private int id;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "DepartmentID")
    private DepartmentVO departmentVO;
//    private final int departmentVO;

    //// FIXME: 08.05.2016
    @Column(name = "IsChief")
    private boolean isChief;

    @Column(name = "Wage")
    private float wage;

    @OneToOne
    @JoinColumn(name = "PersonID")
    private PersonVO personVO;

    public ProfessorVO() {
    }

    public ProfessorVO(boolean isChief, PersonVO personVO, float wage) {
        this.isChief = isChief;
        this.personVO = personVO;
        this.wage = wage;
    }

    public ProfessorVO(PersonVO personVO, DepartmentVO departmentID, boolean isChief, float wage) {
        this.personVO = personVO;
        this.departmentVO = departmentID;
        this.isChief = isChief;
        this.wage = wage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public DepartmentVO getDepartmentVO() {
        return departmentVO;
    }

    public void setDepartmentVO(DepartmentVO departmentVO) {
        this.departmentVO = departmentVO;
    }

    public float getWage() {
        return wage;
    }

    public ProfessorVO setWage(float wage) {
        this.wage = wage;

        return this;
    }

    public boolean isChief() {
        return isChief;
    }

    public void setChief(boolean chief) {
        isChief = chief;
    }

    public PersonVO getPersonVO() {
        return personVO;
    }

    public void setPersonVO(PersonVO personVO) {
        this.personVO = personVO;
    }

    @Override
    public String toString() {
        return "ProfessorVO{" +
                "departmentVO=" + departmentVO +
                ", isChief=" + isChief +
                ", wage=" + wage +
                ", personVO=" + personVO +
                '}';
    }
}
