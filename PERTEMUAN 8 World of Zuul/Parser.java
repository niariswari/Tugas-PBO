import java.util.Scanner;

public class Parser {
    private static Scanner scanner = new Scanner(System.in);

    public static String getCommand() {
        System.out.print("> ");
        return scanner.nextLine();
    }
}
