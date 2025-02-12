package week4.day_2.mapinterface;

import java.util.*;


class BankingSystem<T> {
    private Map<T, Double> accounts = new HashMap<>();
    private TreeMap<Double, T> sortedByBalance = new TreeMap<>();
    private Queue<T> withdrawalQueue = new LinkedList<>();

    //create a method createAccount

    public void createAccount(T accountNumber, double balance) {
        accounts.put(accountNumber, balance);
        sortedByBalance.put(balance, accountNumber);
    }

    //create a method deposit
    public void deposit(T accountNumber, double amount) {
        if (accounts.containsKey(accountNumber)) {
            double newBalance = accounts.get(accountNumber) + amount;
            accounts.put(accountNumber, newBalance);
            sortedByBalance.put(newBalance, accountNumber);
        }
    }
    //create a method  requestWithdrawal
    public void requestWithdrawal(T accountNumber) {
        if (accounts.containsKey(accountNumber)) {
            withdrawalQueue.add(accountNumber);
        }
    }
    //create a method processWithdrawals
    public void processWithdrawals() {
        while (!withdrawalQueue.isEmpty()) {
            T account = withdrawalQueue.poll();
            System.out.println("Processing withdrawal for: " + account);
        }
    }
    //create a method to displaySortedAccounts
    public void displaySortedAccounts() {
        System.out.println("Accounts sorted by balance: " + sortedByBalance);
    }
}

public class ImplementBankingSystem  {
    public static void main(String[] args) {
        BankingSystem<String> bank = new BankingSystem<>();
        bank.createAccount("ACC123", 5000.0);
        bank.createAccount("ACC456", 3000.0);
        bank.createAccount("ACC789", 7000.0);

        bank.deposit("ACC456", 2000.0);
        bank.requestWithdrawal("ACC123");

        bank.processWithdrawals();
        bank.displaySortedAccounts();
    }
}
