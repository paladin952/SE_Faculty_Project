package com.se.detabase.dao.model.users;

import java.io.Serializable;
import java.util.Date;

/**
 * PersonVO database entity. Any PersonVO is a UserVO.
 */
public class PersonVO extends UserVO implements Serializable {
    private String firstName;
    private String lastName;
    private Date dob;
    private long ssn; // CNP
    private String address;
    private int phoneNo;

    public PersonVO(int id, String username, String password, String firstName, String lastName, Date dob, long ssn, String address, int phoneNo) {
        super(id, username, password);
        this.firstName = firstName;
        this.lastName  = lastName;
        this.dob       = dob;
        this.ssn       = ssn;
        this.address   = address;
        this.phoneNo   = phoneNo;
    }

    public String getFirstName() {
        return firstName;
    }

    public PersonVO setFirstName(String firstName) {
        this.firstName = firstName;

        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public PersonVO setLastName(String lastName) {
        this.lastName = lastName;

        return this;
    }

    public Date getDob() {
        return dob;
    }

    public PersonVO setDob(Date dob) {
        this.dob = dob;

        return this;
    }

    public long getSsn() {
        return ssn;
    }

    public PersonVO setSsn(long ssn) {
        this.ssn = ssn;

        return this;
    }

    public String getAddress() {
        return address;
    }

    public PersonVO setAddress(String address) {
        this.address = address;

        return this;
    }

    public int getPhoneNo() {
        return phoneNo;
    }

    public PersonVO setPhoneNo(int phoneNo) {
        this.phoneNo = phoneNo;

        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append("\n. First name: ");
        sb.append(firstName);
        sb.append(". Last name: ");
        sb.append(lastName);
        sb.append(". Date of birth: ");
        sb.append(dob.toString());
        sb.append(". SSN: ");
        sb.append(ssn);
        sb.append(". Address: ");
        sb.append(address);
        sb.append(". Phone no.: ");
        sb.append(phoneNo);

        return sb.toString();
    }
}
