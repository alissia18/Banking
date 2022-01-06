/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;

/**
 *
 * @author aboca
 */
public class Client implements IClient {

    private int id;
    private String firstName;
    private String lastName;
    private static int counter = 0;
    private ArrayList<Account> accountList;
  
    public Client(String name, String surname) {
        this.firstName = name;
        this.lastName = surname;
        counter++;
        this.id = counter;
        this.accountList = new ArrayList<>();
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
   

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public void addAccount(Account newAccount) {
     this.accountList.add(newAccount);
    }

    @Override
    public Account getAccount(int accountNumber) {

        for (Account account : this.accountList) {
            if (accountNumber == account.getAccountNumber()) {
                return account;
            }
        }
        return null;
    }

    @Override
    public void displayAccounts() {
        for (Account account : this.accountList) {
            System.out.println(account);
        }
    }

    @Override
    public String toString() {
        return "(" + this.id + ")" + this.lastName + ", " + this.firstName;
    }
        
    
}
