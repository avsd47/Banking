package main.java.gojek.mode;

import main.java.gojek.BankingService;
import main.java.gojek.OutputPrinter;
import main.java.gojek.model.Bank;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public abstract  class Mode {
    Bank bank;
    BankingService bankingService;
    OutputPrinter outputPrinter;

    public Mode(Bank bank, BankingService bankingService, OutputPrinter outputPrinter){
        this.bank = bank;
        this.bankingService = bankingService;
        this.outputPrinter = outputPrinter;
    }


    public abstract void process() throws IOException;
}
