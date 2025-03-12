package lesson2.practice1.command;

import lesson2.practice1.mode.ModeHolder;
import lesson2.practice1.out.TerminalOutput;

public class DefaultMessageCommand implements Command{

    private final TerminalOutput out;
    private final ModeHolder mode;

    public DefaultMessageCommand(TerminalOutput output, ModeHolder modeHolder) {
        this.out = output;
        this.mode = modeHolder;
    }

    @Override
    public boolean isApplicable(String inputLine) {
        return inputLine != null && !inputLine.startsWith("/");
    }

    @Override
    public void execute(String inputLine) {
        if (!mode.isConnected()) {
            out.print("echo: " + inputLine);
        } else {
            out.print(": ");
        }
    }
}
