package com.se.database.dao.model.users;

import org.apache.commons.lang.builder.ToStringBuilder;

import javax.persistence.*;

@Entity
@Table(name="admin")
public class AdminVO {

    @Id
    @GeneratedValue
    @Column(name = "AdminID")
    private int id;

    @OneToOne
    @JoinColumn(name = "UserID")
    private UserVO userVO;

    public AdminVO() {
    }

    public AdminVO(UserVO userVO) {
        this.userVO = userVO;
    }

    public int getId() {
        return id;
    }

    public UserVO getUserVO() {
        return userVO;
    }

    public AdminVO setUserVO(UserVO userVO) {
        this.userVO = userVO;

        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("Admin ID", id)
                .append("User ID", userVO.getId())
                .toString();
    }
}
