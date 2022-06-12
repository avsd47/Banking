package main.java.gojek.mode;

import main.java.gojek.OutputPrinter;
import main.java.gojek.commands.CommandExecutorFactory;
import main.java.gojek.model.Command;
import main.java.gojek.service.BankingService;
import main.java.gojek.model.Bank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InteractiveMode extends Mode {

    public InteractiveMode(CommandExecutorFactory commandExecutorFactory, OutputPrinter outputPrinter) {
        super(commandExecutorFactory, outputPrinter);
    }

    @Override
    public void process() throws IOException {
        outputPrinter.welcome();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        outputPrinter.enterUserId();
        String input = reader.readLine();
        int userId = Integer.parseInt(input);
        Command command;
        while (true) {
            outputPrinter.menu();
            input = reader.readLine();
            int arg = Integer.parseInt(input);
            if (arg == 5) {
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
                case 4:

                default:
                    outputPrinter.enterValidNumber();
            }
        }
    }

}
