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
public class Bank implements IBank {

    private String bankNumber;
    private String address;
    private ArrayList<Client> clientList = new ArrayList<>();

    public Bank() {
        this.bankNumber = "BMO1926792MTL";
        this.address = "590 Ste-Viateur";

    }

    public String getBankNumber() {
        return this.bankNumber;
    }

    public void setBankNumber(String bankNumber) {
        this.bankNumber = bankNumber;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public void addClient(Client newClient) {
        this.clientList.add(newClient);

    }

    @Override
    public void displayClientAccounts(int clientId) {
        System.out.println(Colors.ANSI_BLUE + "\nNow displaying this Client's Accounts:" + Colors.ANSI_RESET);
        Client currentClient = getClient(clientId);
        currentClient.displayAccounts();
    }

    @Override
    public void displayClientList() {
        System.out.println(Colors.ANSI_BLUE + "\nNow displaying this Bank's Clients:" + Colors.ANSI_RESET);
        for (Client client : this.clientList) {
            System.out.println(client);
        }

    }

    @Override
    public Client getClient(int id) {
        for (Client client : this.clientList) {
            if (client.getId() == id) {
                return client;
            }
        }

        return null;
    }

    @Override
    public Account getClientAccount(int clientId, int accountNumber) {

        Client currentClient = getClient(clientId);
        if (currentClient != null) {

            return currentClient.getAccount(accountNumber);
        }
        return null;

    }

    public Account getAccount(int accountNo) {
        for (Client client : this.clientList) {
            Account currentAccount = client.getAccount(accountNo);
            if (currentAccount != null) {
                return currentAccount;
            }
        }
        return null;
    }
}
