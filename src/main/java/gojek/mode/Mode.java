package main.java.gojek.mode;

import main.java.gojek.OutputPrinter;
import main.java.gojek.commands.CommandExecutor;
import main.java.gojek.commands.CommandExecutorFactory;
import main.java.gojek.model.Command;
import main.java.gojek.service.BankingService;
import main.java.gojek.model.Bank;

import java.io.IOException;

public abstract class Mode {
    CommandExecutorFactory commandExecutorFactory;
    OutputPrinter outputPrinter;

    public Mode(CommandExecutorFactory commandExecutorFactory, OutputPrinter outputPrinter) {
        this.commandExecutorFactory = commandExecutorFactory;
        this.outputPrinter = outputPrinter;
    }

    public void processCommand(int userId, int commandNumber, Command command) throws IOException {
        CommandExecutor commandExecutor = commandExecutorFactory.getCommandExecutor(commandNumber);
        commandExecutor.execute(userId, command);
    }


    public abstract void process() throws IOException;
}
