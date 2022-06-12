package main.java.gojek.commands;

import main.java.gojek.OutputPrinter;
import main.java.gojek.model.Command;
import main.java.gojek.service.BankingService;

import java.io.IOException;

public class BalanceExecutor extends CommandExecutor{

    public BalanceExecutor(BankingService bankingService, OutputPrinter outputPrinter){
        super(bankingService, outputPrinter);
    }

    @Override
    public void execute(int userId, Command command) throws IOException {
        bankingService.checkBalance(userId);
    }

}
