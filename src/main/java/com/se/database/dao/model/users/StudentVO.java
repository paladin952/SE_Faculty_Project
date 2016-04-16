package com.se.database.dao.model.users;

import java.io.Serializable;
import java.util.Date;

/**
 * Student database entity. Any StudentVO is a PersonVO.
 */
public class StudentVO extends PersonVO implements Serializable {
    private int groupID;
    private String status;
    private boolean isExtended;

    public StudentVO(UserVO userVO, String firstName, String lastName, Date dob, long ssn, String address, int phoneNo, int groupID, String status, Boolean isExtended) {
        super(userVO, firstName, lastName, dob, ssn, address, phoneNo);
        this.groupID    = groupID;
        this.status     = status;
        this.isExtended = isExtended;
    }

    public int getGroupID() {
        return groupID;
    }

    public StudentVO setGroupID(int groupID) {
        this.groupID = groupID;

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
        sb.append(groupID);
        sb.append(". Status: ");
        sb.append(status);
        sb.append(". Is extended: ");
        sb.append(isExtended);

        return sb.toString();
    }
}
