package utils;

import java.util.Scanner;

public class ValidationUtils {

    public static int requestInteger(String message, Scanner scanner) {
        int value;
        while (true) {
            try {
                System.out.print(message);
                value = Integer.parseInt(scanner.nextLine());
                if (value > 0) {
                    break;
                }
                System.out.println("El número debe ser mayor a 0.");
            } catch (NumberFormatException e) {
                System.out.println("Debes ingresar un valor mayor a 0.");
            }
        }
        return value;
    }

    public static double requestDouble(String message, Scanner scanner) {
        double value;
        while (true) {
            try {
                System.out.print(message);
                value = Double.parseDouble(scanner.nextLine());
                if (value > 0) {
                    break;
                }
                System.out.println("Debes ingresar un valor mayor a 0.");
            } catch (NumberFormatException e) {
                System.out.println("Ingresá un número válido.");
            }
        }
        return value;
    }

    public static String requestName(String message, Scanner scanner) {
        String name;
        while (true) {
            System.out.print(message);
            name = scanner.nextLine().trim();
            if (!name.isEmpty()) {
                break;
            }
            System.out.println("El nombre no puede estar vacío.");
        }
        return name;
    }
}