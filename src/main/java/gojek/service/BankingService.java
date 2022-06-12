package main.java.gojek.service;

import main.java.gojek.OutputPrinter;
import main.java.gojek.mode.InteractiveMode;
import main.java.gojek.model.Bank;
import main.java.gojek.model.User;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class BankingService {

    Bank bank;

    public BankingService(){
        bank = new Bank(100);
    }

    public void processCredit(int userId, List<Integer> amount) throws IOException {
        User user = bank.getUser(userId);
        user.credit(amount);
    }

    public void processDebit(int userId, List<Integer> amount) throws IOException {
        User user = bank.getUser(userId);
        user.debit(amount);
    }

    public void processTransfer(int fromUserId, int toUserId, List<Integer> amount) throws IOException {
        User fromUser = bank.getUser(fromUserId);
        User toUser = bank.getUser(toUserId);
        fromUser.debit(amount);
        toUser.credit(amount);
    }

    public void checkBalance(int userId) {
        System.out.println("Current Balance is " + bank.getUser(userId).getBalance());
    }
}
