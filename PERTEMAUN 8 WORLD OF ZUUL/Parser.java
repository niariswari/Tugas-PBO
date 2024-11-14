import java.util.Scanner;

public class Parser {
    private static Scanner reader = new Scanner(System.in);

    public static String getCommand() {
        System.out.print("> ");
        return reader.nextLine();
    }
}
