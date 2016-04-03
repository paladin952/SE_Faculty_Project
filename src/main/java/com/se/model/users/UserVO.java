package com.se.model.users;

import java.io.Serializable;

/**
 * Base class for the application's users.
 */
public class UserVO implements Serializable {
    private final int id;
    private String username;
    private String password;

    public UserVO(int id) {
        username = "admin";
        password = "admin";
        this.id = id;
    }

    public UserVO(int id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public UserVO setPassword(String password) {
        this.password = password;

        return this;
    }

    public String getUsername() {
        return username;
    }

    public UserVO setUsername(String username) {
        this.username = username;

        return this;
    }

    public final int getID() {
        return id;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("ID: ");
        sb.append(id);
        sb.append(". Username: ");
        sb.append(username);
        sb.append(". Password: ");
        sb.append(password);

        return sb.toString();
    }
}
