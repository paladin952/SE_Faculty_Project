package com.se.database.dao.model.users;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.springframework.context.annotation.Primary;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * PersonVO database entity. Any PersonVO is a UserVO.
 */
@Entity
@Table(name = "person")
public class PersonVO implements Serializable {

    @Column(name = "FirstName")
    private String firstName;

    @Column(name = "LastName")
    private String lastName;

    @Temporal(TemporalType.DATE)
    @Column(name = "DoB")
    private Date dob;

    @Id
    @Column(name = "SSN")
    private long ssn; // CNP

    @Column(name = "Address")
    private String address;

    @Column(name = "PhoneNo")
    private int phoneNo;

    @OneToOne
    @JoinColumn(name="UserId")
    private UserVO userVO;

    public PersonVO(UserVO userVO, String firstName, String lastName, Date dob, long ssn, String address, int phoneNo) {
        this.userVO = userVO;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.ssn = ssn;
        this.address = address;
        this.phoneNo = phoneNo;
    }

    public PersonVO() {
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

    public UserVO getUserVO() {
        return userVO;
    }

    public void setUserVO(UserVO userVO) {
        this.userVO = userVO;
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
