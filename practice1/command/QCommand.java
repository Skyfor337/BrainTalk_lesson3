package lesson2.practice1.command;

import lesson2.practice1.mode.ModeHolder;
import lesson2.practice1.out.TerminalOutput;

public class QCommand implements Command{

    private final TerminalOutput out;
    private final ModeHolder mode;

    public QCommand(TerminalOutput output, ModeHolder modeHolder) {
        this.out = output;
        this.mode = modeHolder;
    }

    @Override
    public boolean isApplicable(String inputLine) {
        return inputLine != null && inputLine.startsWith("/q");
    }

    @Override
    public void execute(String inputLine) {
        if (mode.isDefaultMode()) {
            out.print("Already in default");
        }

        if (mode.isConnected()) {
            mode.toDefault();
            out.print("Back to default");
        }
    }
}
