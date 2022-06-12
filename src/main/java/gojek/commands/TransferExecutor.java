package main.java.gojek.commands;

import main.java.gojek.OutputPrinter;
import main.java.gojek.model.Command;
import main.java.gojek.service.BankingService;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class TransferExecutor extends CommandExecutor{
    public TransferExecutor(BankingService bankingService, OutputPrinter outputPrinter){
        super(bankingService, outputPrinter);
    }

    @Override
    public void execute(int userId, Command command) throws IOException {
        List<String> values = command.getParams();
        int dollars = 0, cents = 0, toUserId = 0;
        toUserId = Integer.parseInt(values.get(0));
        if (values.size() > 2) {
            dollars = Integer.parseInt(values.get(1).substring(0, values.get(1).length() - 1));
            cents = Integer.parseInt(values.get(2).substring(0, values.get(2).length() - 1));
        } else {
            if (values.get(1).charAt(values.get(1).length() - 1) == 'D') {
                dollars = Integer.parseInt(values.get(1).substring(0, values.get(1).length() - 1));
            } else {
                cents = Integer.parseInt(values.get(1).substring(0, values.get(1).length() - 1));
            }
        }
        bankingService.processTransfer(userId, toUserId, Arrays.asList(dollars, cents));
        outputPrinter.done();
    }
}
