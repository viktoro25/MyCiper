package Runner;

import CLI.CLI;

import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        CLI cli = new CLI();

        if (args.length > 0) {
            // Запуск програми з командного рядка
            cli.processCommand(args);
        } else {
            // Запуск програми через IDE
            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter command (E - ENCRYPT, D - DECRYPT, B - BRUTE_FORCE): ");
            String commandInput = scanner.nextLine();
            String command;

            switch (commandInput.toUpperCase()) {
                case "E":
                    command = "ENCRYPT";
                    break;
                case "D":
                    command = "DECRYPT";
                    break;
                case "B":
                    command = "BRUTE_FORCE";
                    break;
                default:
                    System.out.println("Invalid command.");
                    scanner.close();
                    return;
            }

            System.out.print("Enter file path: ");
            String filePath = scanner.nextLine();

            if (command.equalsIgnoreCase("ENCRYPT") || command.equalsIgnoreCase("DECRYPT")) {
                System.out.print("Enter key: ");
                int key = scanner.nextInt();
                scanner.nextLine(); // Прибрати символ нового рядка після введення числа

                cli.processCommand(new String[]{command, filePath, Integer.toString(key)});

            } else if (command.equalsIgnoreCase("BRUTE_FORCE")) {
                cli.processCommand(new String[]{command, filePath});
            }

            scanner.close();
        }
    }
}
