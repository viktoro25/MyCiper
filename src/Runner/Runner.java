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


                System.out.print("Enter command (ENCRYPT, DECRYPT, BRUTE_FORCE): ");
                String command = scanner.nextLine();

                System.out.print("Enter file path: ");
                String filePath = scanner.nextLine();

                if (command.equalsIgnoreCase("ENCRYPT") || command.equalsIgnoreCase("DECRYPT")) {
                    System.out.print("Enter key: ");
                    int key = scanner.nextInt();
                    scanner.nextLine(); // Прибрати символ нового рядка після введення числа

                    cli.processCommand(new String[]{command, filePath, String.valueOf(key)});
                } else if (command.equalsIgnoreCase("BRUTE_FORCE")) {
                    cli.processCommand(new String[]{command, filePath});
                } else {
                    System.out.println("Invalid command.");
                }

                scanner.close();
            }
        }
    }
