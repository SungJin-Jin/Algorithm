package utils;

public class Utils {

    public static void require(boolean isValid) {
        if (!isValid) throw new IllegalArgumentException("Failed requirement");
    }
}
