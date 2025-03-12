package lesson2.practice1;

import lesson2.practice1.command.*;
import lesson2.practice1.mode.ModeHolder;
import lesson2.practice1.out.TerminalOutput;
import lesson2.practice1.repository.talker.TalkerRepository;


import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CliApplication {

    public List<Command> commands;
    private TerminalOutput out;

    public void start(PrintWriter out_stream) {
        init(out_stream);
        out.print("Cli app started");
    }

    private void init(PrintWriter out_stream) {
        ModeHolder modeHolder = new ModeHolder();
        TalkerRepository talkerRepository = new TalkerRepository();
        this.out = new TerminalOutput(modeHolder, out_stream);
        this.commands = createCommands(out, modeHolder, talkerRepository);
    }

    private List<Command> createCommands(
            TerminalOutput output,
            ModeHolder modeHolder,
            TalkerRepository talkerRepository) {

        List<Command> commands = new ArrayList<>();
        commands.add(new DefaultMessageCommand(output, modeHolder));
        commands.add(new AddCommand(output, talkerRepository));
        commands.add(new ListCommand(output, talkerRepository));
        commands.add(new SendCommand(output));
        commands.add(new GoCommand(output, modeHolder, talkerRepository));
        commands.add(new QCommand(output, modeHolder));
        commands.add(new HelpCommand(output));
        commands.add(new ExitCommand(output));

        return commands;
    }
}
