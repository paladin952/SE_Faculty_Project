package com.se.model.users;

import java.util.Date;

/**
 * Professor database entity. Any ProfessorVO is a PersonVO.
 */
public class ProfessorVO extends PersonVO {
    private final int departmentID;
    private boolean isChief;
    private float wage;

    public ProfessorVO(int id, String username, String password, String firstName, String lastName, Date dob, long ssn, String address, int phoneNo, int departmentID, boolean isChief, float wage) {
        super(id, username, password, firstName, lastName, dob, ssn, address, phoneNo);
        this.departmentID = departmentID;
        this.isChief      = isChief;
        this.wage         = wage;
    }

    public int getDepartmentID() {
        return departmentID;
    }

    public boolean getChief() {
        return isChief;
    }

    public ProfessorVO setChief(boolean chief) {
        isChief = chief;

        return this;
    }

    public float getWage() {
        return wage;
    }

    public ProfessorVO setWage(float wage) {
        this.wage = wage;

        return this;
    }
}
