package main.java.gojek.commands;

import main.java.gojek.OutputPrinter;
import main.java.gojek.model.Command;
import main.java.gojek.service.BankingService;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class DebitExecutor extends CommandExecutor{

    public DebitExecutor(BankingService bankingService, OutputPrinter outputPrinter){
        super(bankingService, outputPrinter);
    }

    @Override
    public void execute(int userId, Command command) throws IOException {
        List<String> values = command.getParams();
        int dollars = 0, cents = 0;
        if (values.size() > 1) {
            dollars = Integer.parseInt(values.get(0).substring(0, values.get(0).length() - 1));
            cents = Integer.parseInt(values.get(1).substring(0, values.get(1).length() - 1));
        } else {
            if (values.get(0).charAt(values.get(0).length() - 1) == 'D') {
                dollars = Integer.parseInt(values.get(0).substring(0, values.get(0).length() - 1));
            } else {
                cents = Integer.parseInt(values.get(0).substring(0, values.get(0).length() - 1));
            }
        }
        bankingService.processDebit(userId, Arrays.asList(dollars, cents));
        outputPrinter.done();
    }
}
