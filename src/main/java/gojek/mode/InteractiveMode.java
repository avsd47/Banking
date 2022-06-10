package main.java.gojek.mode;

import main.java.gojek.BankingService;
import main.java.gojek.OutputPrinter;
import main.java.gojek.model.Bank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InteractiveMode extends Mode{

    public InteractiveMode(Bank bank, BankingService bankingService, OutputPrinter outputPrinter){
        super(bank, bankingService, outputPrinter);
    }

    @Override
    public void process() throws IOException {
        outputPrinter.welcome();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true){
            outputPrinter.menu();
            String input = reader.readLine();
            int arg = Integer.parseInt(input);
            if (arg == 4) {
                System.out.println("Thank you!");
                break;
            }
            switch (arg) {
                case 1:
                    bankingService.processCredit(outputPrinter, reader, bank.getUser());
                    break;
                case 2:
                    bankingService.processDebit(outputPrinter, reader, bank.getUser());
                    break;
                case 3:
                    bankingService.checkBalance(bank.getUser());
                    break;
                default:
                    System.out.println("Please enter valid number.");
            }
        }
    }
}
