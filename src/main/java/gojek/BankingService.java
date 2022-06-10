package main.java.gojek;

import main.java.gojek.model.User;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class BankingService {

    private  List<Integer> processInput(OutputPrinter outputPrinter, BufferedReader reader) throws IOException {
        outputPrinter.enterAmount();
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

    public void processCredit(OutputPrinter outputPrinter, BufferedReader reader, User user) throws IOException {
        List<Integer> amount = processInput(outputPrinter, reader);
        user.credit(amount);
        System.out.println("Done");
    }

    public void processDebit(OutputPrinter outputPrinter, BufferedReader reader, User user) throws IOException {
        List<Integer> amount = processInput(outputPrinter, reader);
        user.debit(amount);
        System.out.println("Done");
    }

    public void checkBalance(User user) {
        System.out.println("Current Balance is " + user.getBalance());
    }
}
