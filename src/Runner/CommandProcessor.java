package Runner;

import CLI.CLI;

import java.util.Scanner;

/**
 * The CommandProcessor class handles the processing of commands for the Caesar Cipher program.
 * It interacts with the user through the console, prompts for commands, and executes them using the CLI.
 */
public class CommandProcessor {
    private final CLI cli;
    private final Scanner scanner;

    /**
     * Constructs a CommandProcessor object with the specified CLI instance.
     *
     * @param cli The CLI instance used to process commands.
     */
    public CommandProcessor(CLI cli) {
        this.cli = cli;
        scanner = new Scanner(System.in);
    }

    /**
     * Prompts for commands, processes them, and executes the corresponding actions.
     * The method continues prompting for commands until a valid command is entered.
     */
    public void processCommands() {
        do {
            System.out.print("Enter command ([ENCRYPT],[DECRYPT],[BRUTE_FORCE]): ");
            String commandInput = scanner.nextLine();
            String command ;

            switch (commandInput.toUpperCase()) {
                case "ENCRYPT":
                    command = "ENCRYPT";
                    break;
                case "DECRYPT":
                    command = "DECRYPT";
                    break;
                case "BRUTE_FORCE":
                    command = "BRUTE_FORCE";
                    break;
                default:
                    System.out.println("Invalid command.");
                    continue; // Return to the beginning of the loop to prompt for a new command
            }

            System.out.print("Enter file path: ");
            String filePath = scanner.nextLine();

            if (command.equalsIgnoreCase("ENCRYPT") || command.equalsIgnoreCase("DECRYPT")) {
                System.out.print("Enter key: ");
                int key = scanner.nextInt();
                scanner.nextLine(); // Remove the newline character after entering the number

                cli.processCommand(new String[]{command, filePath, Integer.toString(key)});
            } else if (command.equalsIgnoreCase("BRUTE_FORCE")) {
                cli.processCommand(new String[]{command, filePath});
            }

            break; // Exit the loop after successfully executing the command
        } while (true);

        scanner.close();
    }
}
