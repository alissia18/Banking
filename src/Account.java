/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 *
 * @author aboca
 */
public class Account implements IAccount {

    protected int accountNumber;
    protected double balance;
    protected String owner;
    protected static int counter;
    protected ArrayList<Transaction> transactions = new ArrayList<>();
    protected String type;
    protected static DecimalFormat df2 = new DecimalFormat("0.00");

    public Account(String type) {
        this.balance = 0.00;
        counter++;
        this.accountNumber = counter;
        this.type = type;
    }

    public Account() {
        this.balance = 0.00;
        counter++;
        this.accountNumber = counter;
    }

    public int getAccountNumber() {
        return this.accountNumber;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return this.balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getOwner() {
        return this.owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    @Override
    public double deposit(double d) {
        this.balance = balance + d;
        Transaction newTransaction = new Transaction("Deposit", d);
        this.addTransaction(newTransaction);
        return this.balance;
    }

    public void addTransaction(Transaction newTransaction) {
        this.transactions.add(newTransaction);
    }

    @Override
    public void displayAllTransactions() {
        for (Transaction transaction : transactions) {
            System.out.println(transaction);
        }
    }

    @Override
    public double withdrawal(double w) {
        Transaction newTransaction = new Transaction("Withdrawal", w);
        this.addTransaction(newTransaction);
        this.balance = balance - w;
        return this.balance;
    }

    @Override
    public ArrayList<Transaction> getTransactions() {
        return this.transactions;
    }

    @Override
    public String toString() {
        return this.type + " (" + this.accountNumber + "):" + df2.format(this.balance) + "$";
    }
}
