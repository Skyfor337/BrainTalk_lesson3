package lesson2.practice1.command;

import lesson2.practice1.mode.ModeHolder;
import lesson2.practice1.out.TerminalOutput;
import lesson2.practice1.repository.talker.TalkerRepository;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GoCommand implements Command{

    private static final Pattern PATTERN = Pattern.compile("^/go +(?<user>\\w+)");

    private final TerminalOutput out;
    private final ModeHolder mode;
    private final TalkerRepository repository;

    public GoCommand(TerminalOutput output, ModeHolder modeHolder, TalkerRepository repository) {
        this.out = output;
        this.mode = modeHolder;
        this.repository = repository;
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
            // todo validate user exists\
            if (repository.isRegistered(user)) {
                out.print("Connected to " + user);
                mode.connectToUser(user);
            } else {
                out.print("User " + user + " is not registered!");
            }
        }
    }
}
