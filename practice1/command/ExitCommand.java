package lesson2.practice1.command;

import lesson2.practice1.out.TerminalOutput;

public class ExitCommand implements Command{

    private final TerminalOutput out;

    public ExitCommand(TerminalOutput output) {
        this.out = output;
    }

    @Override
    public boolean isApplicable(String inputLine) {
        return inputLine.startsWith("/exit");
    }

    @Override
    public void execute(String inputLine) {
        out.print("Buy!");
        System.exit(0);
    }
}
