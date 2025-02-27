package lesson2.practice1.mode;

public class ModeHolder {

    public static final String DEFAULT_MODE = "DEFAULT";
    public static final String INTERCONNECT_MODE = "INTERCONNECT";

    private String currentMode = DEFAULT_MODE;
    private String currentConnectedUser;

    public void connectToUser(String user) {
        currentConnectedUser = user;
        currentMode = INTERCONNECT_MODE;
    }

    public void toDefault() {
        currentConnectedUser = null;
        currentMode = DEFAULT_MODE;
    }

    public boolean isConnected() {
        return currentMode.equals(INTERCONNECT_MODE);
    }

    public boolean isDefaultMode() {
        return currentMode.equals(DEFAULT_MODE);
    }

    public String getConnectedUser() {
        return currentConnectedUser;
    }
}
