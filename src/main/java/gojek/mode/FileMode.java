package main.java.gojek.mode;

import main.java.gojek.OutputPrinter;
import main.java.gojek.commands.CommandExecutorFactory;
import main.java.gojek.model.Command;
import main.java.gojek.service.BankingService;
import main.java.gojek.model.Bank;

import java.io.*;

public class FileMode extends Mode {
    private String fileName;

    public FileMode(CommandExecutorFactory commandExecutorFactory, OutputPrinter outputPrinter, String fileName) {
        super(commandExecutorFactory, outputPrinter);

    }

    @Override
    public void process() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String input = reader.readLine();
        int userId = Integer.parseInt(input);
        Command command;
        while (true) {
            outputPrinter.menu();
            input = reader.readLine();
            int arg = Integer.parseInt(input);
            if (arg == 4) {
                System.out.println("Thank you!");
                break;
            }
            switch (arg) {
                case 1:
                    outputPrinter.enterAmount();
                    input = reader.readLine();
                    command = new Command(input);
                    processCommand(userId, 1, command);
                    break;
                case 2:
                    outputPrinter.enterAmount();
                    input = reader.readLine();
                    command = new Command(input);
                    processCommand(userId, 2, command);
                    break;
                case 3:
                    outputPrinter.enterTranferIdAndAmount();
                    input = reader.readLine();
                    command = new Command(input);
                    processCommand(userId, 3, command);
                    break;
                default:
                    outputPrinter.enterValidNumber();
            }
        }
    }
}
