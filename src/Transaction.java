/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.text.DecimalFormat;

/**
 *
 * @author aboca
 */
public class Transaction implements ITransaction {

    private String type;
    private double amount;
    private static DecimalFormat df2 = new DecimalFormat("0.00");

    public Transaction(String transactionType, double amt) {
        this.type = transactionType;
        this.amount = amt;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getAmount() {
        return this.amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        String str = this.type + " of " + df2.format(this.amount) + "$";
        return str;

    }

}
