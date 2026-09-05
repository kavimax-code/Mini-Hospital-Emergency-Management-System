public class UI {
    public static final String RESET = "\u001b[0m";
    public static final String CYAN = "\u001b[36m";
    public static final String GREEN = "\u001b[32m";
    public static final String YELLOW = "\u001b[33m";
    public static final String RED = "\u001b[31m";

    public static void printHeader(String title) {
        System.out.println(CYAN + "==================================================");
        System.out.println("          " + title.toUpperCase());
        System.out.println("==================================================" + RESET);
    }

    public static void printDivider() {
        System.out.println("--------------------------------------------------");
    }

    public static void printSuccess(String message) {
        System.out.println(GREEN + "[✔] " + message + RESET);
    }

    public static void printError(String message) {
        System.out.println(RED + "[✖] " + message + RESET);
    }
}