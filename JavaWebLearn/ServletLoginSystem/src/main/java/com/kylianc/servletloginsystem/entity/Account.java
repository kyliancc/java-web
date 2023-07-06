package com.kylianc.servletloginsystem.entity;

import java.io.Serial;
import java.io.Serializable;

/**
 * Entity class of accounts
 * Contains username and password of an account.
 */
public class Account implements Serializable {
    @Serial
    private static final long serialVersionUID = -2499481219218429370L;

    // Attributes
    private String username;
    private String password;

    public Account() {}

    public Account(String username, String password) {
        this.username = username;
        this.password = password;
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
        return "Account{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
