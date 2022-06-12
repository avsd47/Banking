package main.java.gojek.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Command {
    private static final String SPACE = " ";
    private int commandNumber;

    private List<String> params;

    public int getCommandNumber() {
        return commandNumber;
    }

    public List<String> getParams() {
        return params;
    }

    public Command(String input) {
        params = Arrays.stream(input.trim().split(SPACE)).map(String::trim)
                .filter(token -> (token.length() > 0)).collect(Collectors.toList());
    }

}
