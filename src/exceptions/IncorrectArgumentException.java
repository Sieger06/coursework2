package exceptions;

public class IncorrectArgumentException extends Exception {

    public IncorrectArgumentException(String argument) {
        this.argument = argument;
    }

    private final String argument;

    public String getArgument() {
        return argument;
    }

    @Override
    public String toString() {
        return argument;
    }
}