package main.java.gojek;

import main.java.gojek.commands.CommandExecutorFactory;
import main.java.gojek.exception.InvalidModeException;
import main.java.gojek.service.BankingService;
import main.java.gojek.mode.FileMode;
import main.java.gojek.mode.InteractiveMode;
import main.java.gojek.model.Bank;

import java.io.IOException;

public class Main {
    public static void main(final String[] args) throws IOException {
        OutputPrinter outputPrinter = new OutputPrinter();
        BankingService bankingService = new BankingService();
        CommandExecutorFactory commandExecutorFactory = new CommandExecutorFactory(bankingService);

        if (isInteractiveMode(args)) {
            new InteractiveMode(commandExecutorFactory, outputPrinter).process();
        } else if (isFileInputMode(args)) {
            new FileMode(commandExecutorFactory, outputPrinter, args[0]).process();
        } else {
            throw new InvalidModeException();
        }
    }

    private static boolean isFileInputMode(final String[] args) {
        return args.length == 1;
    }

    private static boolean isInteractiveMode(final String[] args) {
        return args.length == 0;
    }
}
