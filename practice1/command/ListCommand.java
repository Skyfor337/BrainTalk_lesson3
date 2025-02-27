package lesson2.practice1.command;

import lesson2.practice1.out.TerminalOutput;
import lesson2.practice1.repository.talker.TalkerRepository;

public class ListCommand implements Command {

    private final TerminalOutput out;
    private final TalkerRepository repository;

    public ListCommand(TerminalOutput output, TalkerRepository repository) {
        this.out = output;
        this.repository = repository;
    }

    @Override
    public boolean isApplicable(String inputLine) {
        return inputLine != null && inputLine.startsWith("/list");
    }

    @Override
    public void execute(String inputLine) {
        if (repository.isEmpty()) {
            out.print("No talkers yet");
            return;
        }

        StringBuilder result = new StringBuilder();
        result.append("Registered talkers:\n\r");
        for (String user : repository.findAll()) {
            if (user != null) {
                result.append(" - " + user + "\n\r");
            }
        }
        out.print(result.toString());
    }
}

