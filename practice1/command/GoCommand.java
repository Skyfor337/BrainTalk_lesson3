package lesson2.practice1.command;

import lesson2.practice1.mode.ModeHolder;
import lesson2.practice1.out.TerminalOutput;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GoCommand implements Command{

    private static final Pattern PATTERN = Pattern.compile("^/go +(?<user>\\w+)");

    private final TerminalOutput out;
    private final ModeHolder mode;

    public GoCommand(TerminalOutput output, ModeHolder modeHolder) {
        this.out = output;
        this.mode = modeHolder;
    }

    @Override
    public boolean isApplicable(String inputLine) {
        return inputLine != null && inputLine.startsWith("/go");
    }

    @Override
    public void execute(String inputLine) {
        Matcher matcher = PATTERN.matcher(inputLine);
        if (matcher.find()) {
            String user = matcher.group("user");
            // todo validate user exists
            mode.connectToUser(user);
            out.print("Connected to " + user);
        }
    }
}
