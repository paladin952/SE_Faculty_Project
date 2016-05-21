package com.se.database.dao.model.users;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Clapa Lucian on 4/3/2016.
 */
@Entity
@Table(name="user")
public class UserVO implements Serializable {

    /**
     * The user's id
     */
    @Id
    @GeneratedValue
    @Column(name="UserID")
    private int id;

    /**
     * The username
     */
    @Column(name="Username")
    private String username;

    /**
     * The password
     */
    @Column(name="Password")
    private String password;

    /**
     * The constructor
     * @param username The username
     * @param password The pasword
     */
    public UserVO(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public UserVO(UserVO userVO){
        this.username = userVO.getUsername();
        this.password = userVO.getPassword();
    }

    /**
     * Default constructor for serialization
     * DO NOT REMOVE IT
     */
    public UserVO() {
    }

    /**
     * GETTERS AND SETTERS used for hibernate
     */
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Id=" + id + ", Username=" + username + ", Password=" + password;
    }
}
