/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Scanner;

/**
 *
 * @author aboca
 */
public class UserInputManager implements IUserInputManager {

    @Override
    public int retrieveAccountNumber() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter your account number:");
        int accountNo = sc.nextInt();

        return accountNo;
    }

    public int retrieveAccountNumber(Bank currentBank) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter your account number:");
        int accountNo = sc.nextInt();

        Account currentAccount = currentBank.getAccount(accountNo);

        if (currentAccount == null) {
             System.out.println(Colors.ANSI_RED + "Invalid account number! Please try again!" + Colors.ANSI_RESET);
            return retrieveAccountNumber(currentBank);
        } else {
            return accountNo;
        }
    }

    @Override
    public Account retrieveAccountType() {
        Scanner sc = new Scanner(System.in);
        String type = "";

        while (!type.equals("S") && !type.equals("C")) {
            System.out.println("What type of account would you like to create?");
            System.out.println("S for savings, C for chequing");
            type = sc.nextLine().toUpperCase();

            if (!type.equals("S") && !type.equals("C")) {
                System.out.println(Colors.ANSI_RED + "Invalid type! Please try again!" + Colors.ANSI_RESET);
            }
        }

        switch (type) {
            case "S":
                return new SavingsAccount();

            case "C":
                CheckingAccount newChecking = new CheckingAccount();
                return newChecking;

            default:
                return null;
        }

    }

    @Override
    public int retrieveClientId() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter your client ID:");
        return sc.nextInt();
    }

    public int retrieveClientId(Bank currentBank) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter your client ID:");
        int id = sc.nextInt();

        Client currentClient = currentBank.getClient(id);

        if (currentClient == null) {
             System.out.println(Colors.ANSI_RED + "Invalid Client ID! Please try again!" + Colors.ANSI_RESET);
            return retrieveClientId(currentBank);
        } else {
            return id;
        }
    }

    @Override
    public Client retrieveClientInfo() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter your last name");
        String lastName = sc.nextLine();

        System.out.println("Please enter your first name");
        String firstName = sc.nextLine();

        return new Client(firstName, lastName);
    }

    @Override
    public double retrieveTransactionAmount() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the transaction amount:");
        double transactionAmount;
        transactionAmount = sc.nextDouble();
        return transactionAmount;
    }

    @Override
    public int retrieveUserOption() {
        Scanner sc = new Scanner(System.in);

        System.out.println(Colors.ANSI_CYAN + "\n====================================" + Colors.ANSI_RESET);
        System.out.println("\n[1] add a new Client");
        System.out.println("[2] add a new Account");
        System.out.println("[3] make a deposit");
        System.out.println("[4] make a withdrawal");
        System.out.println("[5] view the list of transactions for an account");
        System.out.println("[6] view the list of Clients at this bank");
        System.out.println("[7] view the list of accounts belonging to a Client");
        System.out.println("[0] exit");

        return sc.nextInt();

    }
}
