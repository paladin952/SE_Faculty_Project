package com.se.database.dao.model.users;

import com.se.database.dao.model.academic.groups.StudentGroupVO;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Student database entity. Any StudentVO is a PersonVO.
 */
@Entity
@Table(name = "student")
public class StudentVO implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "StudentID")
    private int id;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "GroupID")
    private StudentGroupVO group;

    @Column(name = "Status")
    private String status;

    @Column(name = "IsExtended")
    private boolean isExtended;

    @OneToOne
    @JoinColumn(name = "PersonID")
    private PersonVO personVO;

    public StudentVO() {}

    public StudentVO(String status, PersonVO personVO, boolean isExtended) {
        this.status = status;
        this.personVO = personVO;
        this.isExtended = isExtended;
    }

    public StudentVO(PersonVO personVO, StudentGroupVO group, String status, boolean isExtended) {
        this.personVO = personVO;
        this.group = group;
        this.status = status;
        this.isExtended = isExtended;
    }

    public int getId() {
        return id;
    }

    public PersonVO getPersonVO() {
        return personVO;
    }

    public StudentVO setPersonVO(PersonVO personVO) {
        this.personVO = personVO;

        return this;
    }

    public StudentGroupVO getGroup() {
        return group;
    }

    public StudentVO setGroup(StudentGroupVO group) {
        this.group = group;

        return this;
    }

    public String getStatus() {
        return status;
    }

    public StudentVO setStatus(String status) {
        this.status = status;

        return this;
    }

    public Boolean getExtended() {
        return isExtended;
    }

    public StudentVO setExtended(Boolean extended) {
        isExtended = extended;

        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append("\n. Group ID: ");
        sb.append(group);
        sb.append(". Status: ");
        sb.append(status);
        sb.append(". Is extended: ");
        sb.append(isExtended);

        return sb.toString();
    }
}
