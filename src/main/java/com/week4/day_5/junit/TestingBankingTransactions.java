package com.week4.day_5.junit;

public class TestingBankingTransactions {

    private double balance;

    // Constructor to initialize the balance
    public TestingBankingTransactions(double initialBalance) {
        this.balance = initialBalance;
    }

    // Method to deposit money into the account
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    // Method to withdraw money from the account
    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }

    // Method to get the current balance
    public double getBalance() {
        return balance;
    }

    // Main method to test the BankAccount functionality
    public static void main(String[] args) {
        TestingBankingTransactions account = new TestingBankingTransactions(1000.0);

        // Test deposit
        account.deposit(500.0);
        System.out.println("Balance after deposit: " + account.getBalance());

        // Test withdraw
        if (account.withdraw(200.0)) {
            System.out.println("Balance after withdrawal: " + account.getBalance());
        } else {
            System.out.println("Insufficient funds for withdrawal.");
        }

        // Test insufficient funds withdrawal
        if (account.withdraw(1500.0)) {
            System.out.println("Balance after withdrawal: " + account.getBalance());
        } else {
            System.out.println("Insufficient funds for withdrawal.");
        }
    }
}

