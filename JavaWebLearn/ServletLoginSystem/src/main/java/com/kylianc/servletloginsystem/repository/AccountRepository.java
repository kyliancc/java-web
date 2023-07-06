package com.kylianc.servletloginsystem.repository;



import com.kylianc.servletloginsystem.entity.Account;

import java.util.List;

/**
 * provide methods that are in order to access database =w=.
 */
public interface AccountRepository {
    void insert(Account account);

    void delete(String username);

    void update(Account account);

    Account selectByName(String username);

    String getPasswordByName(String username);

    List<Account> selectAll();
}
