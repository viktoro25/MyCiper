package Runner;

import CLI.CLI;

public class Runner {
    public static void main(String[] args) {
        CLI cli = new CLI();
        CommandProcessor commandProcessor = new CommandProcessor(cli);
        commandProcessor.processCommands();
    }
}