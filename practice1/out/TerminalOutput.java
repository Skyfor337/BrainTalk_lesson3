package lesson2.practice1.out;

import lesson2.practice1.mode.ModeHolder;

public class TerminalOutput {

    private static final String DEFAULT_PROMPT = "#";
    private final ModeHolder modeHolder;

    public TerminalOutput(ModeHolder modeHolder) {
        this.modeHolder = modeHolder;
    }

    public void print(String message) {
        System.out.println(message);
        showPrompt();
    }

    private void showPrompt() {
        if (modeHolder.isConnected()) {
            System.out.print(modeHolder.getConnectedUser() + DEFAULT_PROMPT);
        } else {
            System.out.print(DEFAULT_PROMPT);
        }
    }
}