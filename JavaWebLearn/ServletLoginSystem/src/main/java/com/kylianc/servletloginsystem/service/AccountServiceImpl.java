package com.kylianc.servletloginsystem.service;


import com.kylianc.servletloginsystem.entity.Account;
import com.kylianc.servletloginsystem.repository.AccountRepository;
import com.kylianc.servletloginsystem.repository.AccountRepositoryImpl;

/**
 * Almost all the business logics should be in service objects
 * <p>
 * It depends on a repository object to access database
 */
public class AccountServiceImpl implements AccountService {
    private final AccountRepository repository;

    private static final AccountServiceImpl INSTANCE = new AccountServiceImpl();

    private AccountServiceImpl() {
        // instantiate repository object
        repository = AccountRepositoryImpl.getInstance();
    }

    /**
     * Controller objects should get AccountServiceImpl instance by this method.
     * @return Instance of AccountServiceImpl.
     */
    public static AccountServiceImpl getInstance() {
        return INSTANCE;
    }

    // Some business logics
    @Override
    public boolean isAccountExists(String username) {
        return repository.selectByName(username) != null;
    }

    @Override
    public void insertAccount(String username, String password) {
        repository.insert(new Account(username, password));
    }

    @Override
    public boolean loginAccount(String username, String password) {
        return password.equals(repository.getPasswordByName(username));
    }
}
