/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author aboca
 */
public class Banking {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Client currentClient = null;
        Account currentAccount = null;
        int action, clientId=0, accountNo;
        Bank currentBank = new Bank();
        UserInputManager m = new UserInputManager();
        System.out.println(Colors.ANSI_PURPLE + "Welcome to BankTech! What would you like to do?" + Colors.ANSI_RESET);

        do {
            action = m.retrieveUserOption();

            if (action == 2 || action == 3 || action == 4 || action == 5 || action == 7) {
                clientId = m.retrieveClientId(currentBank);
                currentClient = currentBank.getClient(clientId);
                if (action == 3 || action == 4 || action == 5) {
                    accountNo = m.retrieveAccountNumber(currentBank);
                    currentAccount = currentClient.getAccount(accountNo);
                }
            }
            switch (action) {
                case 0 -> {
                    System.out.println(Colors.ANSI_PURPLE + "\nThank you for using BankTech" + Colors.ANSI_PURPLE);
                    System.out.println("Now exiting application." + Colors.ANSI_RESET);
                }
                case 1 -> Banking.addNewClient(currentBank, m);
                case 2 -> Banking.addNewAccount(currentClient, m);
                case 3 -> Banking.transaction(currentAccount, m, "Deposit");
                case 4 -> Banking.transaction(currentAccount, m, "Withdrawal");
                case 5 -> {
                    currentAccount.displayAllTransactions();
                    System.out.println(currentAccount);
                }
                case 6 -> currentBank.displayClientList();
                case 7 -> currentBank.displayClientAccounts(clientId);
                default -> System.out.println("invalid number! Please input a different number!");
            }
        } while (!(action == 0));
    }

    public static void addNewClient(Bank currentBank, UserInputManager m) {
        Client newClient = m.retrieveClientInfo();
        currentBank.addClient(newClient);
        System.out.println(Colors.ANSI_GREEN + "A new Client " + newClient + " has been added." + Colors.ANSI_RESET);
    }

    public static void addNewAccount(Client currentClient, UserInputManager m) {
        Account newAccount = m.retrieveAccountType();
        currentClient.addAccount(newAccount);
        System.out.println(Colors.ANSI_GREEN + "A new Account " + newAccount + " has been added." + Colors.ANSI_RESET);
    }

    public static void transaction(Account currentAccount, UserInputManager m, String type) {
        double amount;

        amount = m.retrieveTransactionAmount();

        if (type.equals("Deposit")) {
            currentAccount.deposit(amount);
        }

        if (type.equals("Withdrawal")) {
            currentAccount.withdrawal(amount);
        }
        System.out.println(Colors.ANSI_GREEN + type + " complete." + Colors.ANSI_RESET);
        System.out.println(currentAccount);
        
    }
}
