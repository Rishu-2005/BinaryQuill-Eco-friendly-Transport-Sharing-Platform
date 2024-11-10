package com.databasesetup.account;

public interface AccountDAO {

    void addUser(AccountData user);

    AccountData getUserbyid(int id);

    void deleteUser(AccountData user);
}
