package lesson2.practice1.command;

public interface Command {

    boolean isApplicable(String inputLine);

    void execute(String inputLine);
}
