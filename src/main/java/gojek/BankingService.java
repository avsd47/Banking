package main.java.gojek;

import main.java.gojek.Model.Balance;
import main.java.gojek.Model.User;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BankingService {
    public static void main(String[] args) throws IOException {
        new BankingService().execute();
    }

    private void execute() throws IOException {
        User user = new User();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            System.out.print("Select an option:\n1. Credit\n2. Debit\n3. Check Balance\n4. Exit\n ==> ");
            String input = reader.readLine();
            int arg = Integer.parseInt(input);
            if (arg == 4) {
                System.out.println("Thank you!");
                break;
            }
            switch (arg) {
                case 1:
                    processCredit(reader, user.getBalance());
                    break;
                case 2:
                    processDebit(reader, user.getBalance());
                    break;
                case 3:
                    checkBalance(user.getBalance());
                    break;
                default:
                    System.out.println("Please enter valid number.");
            }
        }
    }

    private Balance processInput(BufferedReader reader) throws IOException {
        System.out.println("Enter Amount:");
        String input = reader.readLine();
        String[] values = input.split(" ");
        Balance amount = new Balance();
        if (values.length > 1) {
            amount.setDollars(Integer.parseInt(values[0].substring(0, values[0].length() - 1)));
            amount.setCents(Integer.parseInt(values[1].substring(0, values[1].length() - 1)));
        } else {
            if (values[0].charAt(values[0].length() - 1) == 'D') {
                amount.setDollars(Integer.parseInt(values[0].substring(0, values[0].length() - 1)));
            } else {
                amount.setCents(Integer.parseInt(values[0].substring(0, values[0].length() - 1)));
            }
        }
        return amount;
    }

    private void processCredit(BufferedReader reader, Balance balance) throws IOException {
        Balance amount = processInput(reader);
        balance.credit(amount);
        System.out.println("Done");
    }

    private void processDebit(BufferedReader reader, Balance balance) throws IOException {
        Balance amount = processInput(reader);
        balance.debit(amount);
        System.out.println("Done");
    }

    private void checkBalance(Balance balance) {
        System.out.println("Current Balance is " + balance.getBalance());
    }
}
