package main.java.gojek;

import main.java.gojek.Model.User;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

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
                    processCredit(reader, user);
                    break;
                case 2:
                    processDebit(reader, user);
                    break;
                case 3:
                    checkBalance(user);
                    break;
                default:
                    System.out.println("Please enter valid number.");
            }
        }
    }

    private List<Integer> processInput(BufferedReader reader) throws IOException {
        System.out.println("Enter Amount:");
        String input = reader.readLine();
        String[] values = input.split(" ");
        int dollars = 0, cents = 0;
        if (values.length > 1) {
            dollars = Integer.parseInt(values[0].substring(0, values[0].length() - 1));
            cents = Integer.parseInt(values[1].substring(0, values[1].length() - 1));
        } else {
            if (values[0].charAt(values[0].length() - 1) == 'D') {
                dollars = Integer.parseInt(values[0].substring(0, values[0].length() - 1));
            } else {
                cents = Integer.parseInt(values[0].substring(0, values[0].length() - 1));
            }
        }
        return Arrays.asList(dollars, cents);
    }

    private void processCredit(BufferedReader reader, User user) throws IOException {
        List<Integer> amount = processInput(reader);
        user.credit(amount);
        System.out.println("Done");
    }

    private void processDebit(BufferedReader reader, User user) throws IOException {
        List<Integer> amount = processInput(reader);
        user.debit(amount);
        System.out.println("Done");
    }

    private void checkBalance(User user) {
        System.out.println("Current Balance is " + user.getBalance());
    }
}
