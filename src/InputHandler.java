
import java.util.Scanner;

public class InputHandler {

    private Scanner scanner = new Scanner(System.in);

    // Read text from the user
    public String readText(String message) {

        System.out.print(message);
        return scanner.nextLine();
    }
}