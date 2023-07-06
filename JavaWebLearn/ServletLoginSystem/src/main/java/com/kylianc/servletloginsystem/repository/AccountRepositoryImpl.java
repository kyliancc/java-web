package com.kylianc.servletloginsystem.repository;



import com.kylianc.servletloginsystem.entity.Account;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A repository class that accesses database
 */
public class AccountRepositoryImpl implements AccountRepository {

    /**
     *     I used a map to replace a database, for convenience lol.
     * <p>
     *     The key is username, the value is password.
     */
    private static final Map<String, String> DATABASE = new HashMap<>();

    private static final AccountRepositoryImpl INSTANCE = new AccountRepositoryImpl();

    private AccountRepositoryImpl() {}

    /**
     * Service objects should get AccountRepositoryImpl Instance by this method.
     * @return Instance of AccountRepositoryImpl.
     */
    public static AccountRepositoryImpl getInstance() {
        return INSTANCE;
    }

    // insert/delete/update methods should be synchronized bcs of the thread safety.
    @Override
    public synchronized void insert(Account account) {
        DATABASE.put(account.getUsername(), account.getPassword());
    }

    @Override
    public synchronized void delete(String username) {
        DATABASE.remove(username);
    }

    @Override
    public synchronized void update(Account account) {
        DATABASE.replace(account.getUsername(), account.getPassword());
    }

    @Override
    public Account selectByName(String username) {
        String password = DATABASE.get(username);
        if (password != null) {
            return new Account(username, password);
        }
        else {
            return null;
        }
    }

    @Override
    public String getPasswordByName(String username) {
        System.out.println("Got password " + DATABASE.get(username) + " of " + username);
        return DATABASE.get(username);
    }

    @Override
    public List<Account> selectAll() {
        List<Account> accounts = new ArrayList<>();

        for (String key : DATABASE.keySet()) {
            Account account = new Account(key, DATABASE.get(key));
            accounts.add(account);
        }

        return accounts;
    }
}
