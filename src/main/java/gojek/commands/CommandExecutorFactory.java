package main.java.gojek.commands;

import main.java.gojek.OutputPrinter;
import main.java.gojek.service.BankingService;

import java.util.HashMap;
import java.util.Map;

public class CommandExecutorFactory {
    private Map<Integer, CommandExecutor> commands = new HashMap<>();

    public CommandExecutorFactory(BankingService bankingService){
        OutputPrinter outputPrinter = new OutputPrinter();
        commands.put(1,new CreditExecutor(bankingService, outputPrinter));
        commands.put(2, new DebitExecutor(bankingService, outputPrinter));
        commands.put(3, new TransferExecutor(bankingService, outputPrinter));
        commands.put(4, new BalanceExecutor(bankingService, outputPrinter));
    }

    public CommandExecutor getCommandExecutor(int commandNumber){
        return commands.get(commandNumber);
    }
}
