package lesson2.practice1.out;

import lesson2.practice1.mode.ModeHolder;

import java.io.PrintWriter;

public class TerminalOutput {

    private static final String DEFAULT_PROMPT = "#";
    private final ModeHolder modeHolder;
    private final PrintWriter out;

    public TerminalOutput(ModeHolder modeHolder, PrintWriter out_stream) {
        this.out = out_stream;
        this.modeHolder = modeHolder;
    }

    public void print(String message) {
        if (modeHolder.isConnected()) {
            //TODO без println он накапливает в буфер этот промт
            // потому что курсор терминала как-то блокирует печать out.print(). То есть прога хочет написать,
            // но всё залоченно, поэтому оно накапливается и в итоге за раз выплёвывается
            out.println(String.format("%s%s%s", DEFAULT_PROMPT, modeHolder.getConnectedUser(), message));
        } else {
            out.println(String.format("%s %s", DEFAULT_PROMPT, message));
        }
    }

//    private void showPrompt() {
//        if (modeHolder.isConnected()) {
//            out.print("#" + modeHolder.getConnectedUser() + ":" + DEFAULT_PROMPT);
//        } else {
//            out.print(DEFAULT_PROMPT);
//        }
//    }
}