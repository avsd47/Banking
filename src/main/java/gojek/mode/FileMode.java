package main.java.gojek.mode;

import main.java.gojek.OutputPrinter;
import main.java.gojek.Service.BankingService;
import main.java.gojek.model.Bank;

import java.io.*;

public class FileMode extends Mode {
    private String fileName;

    public FileMode(Bank bank, BankingService bankingService, OutputPrinter outputPrinter, String fileName) {
        super(bank, bankingService, outputPrinter);

    }

    @Override
    public void process() throws IOException {
        File file = new File(fileName);
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            outputPrinter.fileNotFound();
            return;
        }
        while (true) {
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
                    return;
            }
        }
    }
}
