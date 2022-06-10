package main.java.gojek;

public class OutputPrinter {
    public void welcome(){
        printWithNewLine("Welcome to Go-Jek Banking.");
    }

    public void menu(){
        printWithNewLine("Select an option:\n1. Credit\n2. Debit\n3. Check Balance\n4. Exit\n ==> ");
    }

    public void amount(){
        printWithNewLine("Enter Amount:");
    }

    public void thankYou(){
        printWithNewLine("Thank You!");
    }

    public void printWithNewLine(String msg) {
        System.out.println(msg);
    }
}
