package lesson2.practice1.command;

import lesson2.practice1.out.TerminalOutput;
import lesson2.practice1.repository.talker.TalkerRepository;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddCommand implements Command{

    private static final Pattern PATTERN = Pattern.compile("^/add +(?<talker>\\w+)");

    private final TerminalOutput out;
    private final TalkerRepository repository;

    public AddCommand(TerminalOutput output, TalkerRepository repository) {
        this.out = output;
        this.repository = repository;
    }

    @Override
    public boolean isApplicable(String inputLine) {
        return inputLine != null && inputLine.startsWith("/add");
    }

    @Override
    public void execute(String inputLine) {
        // validate empty
        Matcher matcher = PATTERN.matcher(inputLine);
        if (matcher.find()) {
            String talkerToAdd = matcher.group("talker");
            if (repository.isRegistered(talkerToAdd)) {
                out.print("Talker already added");
                return;
            }

            repository.addTalker(talkerToAdd);
            out.print(talkerToAdd + " added");
        };
    }
}
