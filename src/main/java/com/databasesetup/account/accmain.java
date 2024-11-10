package com.databasesetup.account;


import java.util.*;

public class accmain {
    public static void main(String[] args) {
        AccountDAO accountDAO = new AccountDAOimplementer();

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter First Name, Middle Name, Last Name, Email ID, Password, Phone Number, DOB ");
        AccountData accountData = new AccountData(sc.next(), sc.next(), sc.next(), sc.next(), sc.next(), sc.next(), sc.next());
        accountDAO.addUser(accountData);
        System.out.println("User added successfully");
        AccountData savedUser = accountDAO.getUserbyid(1);
        System.out.println(accountDAO);
    }
}
