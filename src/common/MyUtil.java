package common;

public class MyUtil {
    public static String castNums(String str) {
        return str.replace("]", "}").replace("[", "{");
    }
}
