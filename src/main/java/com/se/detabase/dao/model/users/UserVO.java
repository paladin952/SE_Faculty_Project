package com.se.detabase.dao.model.users;

import java.io.Serializable;

/**
 * Created by Clapa Lucian on 4/3/2016.
 */
public class UserVO implements Serializable {

    /**
     * The user's id
     */
    private int id;

    /**
     * The username
     */
    private String username;

    /**
     * The password
     */
    private String password;

    /**
     * The constructor
     * @param id The id
     * @param username The username
     * @param password The pasword
     */
    public UserVO(int id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
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
}
