package lesson2.practice1.command;

import lesson2.practice1.out.TerminalOutput;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SendCommand implements Command{

    private static final Pattern PATTERN = Pattern.compile("^/send +(?<user>\\w+) +(?<message>.*)");

    private final TerminalOutput out;

    public SendCommand(TerminalOutput output) {
        this.out = output;
    }

    @Override
    public boolean isApplicable(String inputLine) {
        return inputLine != null && inputLine.startsWith("/send");
    }

    @Override
    public void execute(String inputLine) {
        // todo validate empty
        Matcher matcher = PATTERN.matcher(inputLine);
        if (matcher.find()) {
            String user = matcher.group("user");
            // todo validate user exists
            String message = matcher.group("message");
            out.print("echo from " + user + ": " + message);
        }
    }
}
