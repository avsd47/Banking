package main.java.gojek.commands;

import main.java.gojek.OutputPrinter;
import main.java.gojek.model.Command;
import main.java.gojek.service.BankingService;

import java.io.IOException;

public abstract class CommandExecutor {
    protected BankingService bankingService;
    protected OutputPrinter outputPrinter;

    public CommandExecutor(BankingService bankingService, OutputPrinter outputPrinter){
        this.bankingService = bankingService;
        this.outputPrinter = outputPrinter;
    }

    public abstract void execute(int userId, Command command) throws IOException;
}
