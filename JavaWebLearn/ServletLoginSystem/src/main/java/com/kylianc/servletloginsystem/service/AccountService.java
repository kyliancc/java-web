package com.kylianc.servletloginsystem.service;

/**
 * Provides some business logic methods
 */
public interface AccountService {
    boolean isAccountExists(String username);

    void insertAccount(String username, String password);

    boolean loginAccount(String username, String password);
}
