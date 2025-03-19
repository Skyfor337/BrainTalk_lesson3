package lesson2.practice1.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CliPattern {
    public static String isCorrectCommandWithUser(String command, String name) {
        Pattern comandPattern = Pattern.compile("^/" + name + " +(?<user>\\w+)");
        Matcher matcher = comandPattern.matcher(command);
        String user = matcher.group("user");
        return matcher.find() ? user : "";
    }
}
