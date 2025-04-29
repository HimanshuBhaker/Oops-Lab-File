package bankmanagementsystem;

import java.util.Scanner;

public class InputHelper {
    private static final Scanner scanner = new Scanner(System.in);

    // Get String Input
    public static String getString(String message) {
        System.out.print(message);
        return scanner.nextLine();
    }

    // Get Integer Input
    public static int getInt(String message) {
        System.out.print(message);
        while (!scanner.hasNextInt()) {
            System.out.print(" Invalid input. Please enter a valid integer: ");
            scanner.next();
        }
        int value = scanner.nextInt();
        scanner.nextLine(); // clear buffer
        return value;
    }

    // Get Double Input
    public static double getDouble(String message) {
        System.out.print(message);
        while (!scanner.hasNextDouble()) {
            System.out.print("Invalid input. Please enter a valid number: ");
            scanner.next();
        }
        double value = scanner.nextDouble();
        scanner.nextLine(); // clear buffer
        return value;
    }
}
