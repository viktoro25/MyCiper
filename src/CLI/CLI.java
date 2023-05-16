package CLI;

import CaesarCipher.CaesarCipher;
import FileService.FileService;

import java.io.IOException;

public class CLI {
    private static final String ENCRYPT_COMMAND = "ENCRYPT";
    private static final String DECRYPT_COMMAND = "DECRYPT";
    private static final String BRUTE_FORCE_COMMAND = "BRUTE_FORCE";

    private final CaesarCipher caesarCipher;
    private final FileService fileService;

    public CLI() {
        caesarCipher = new CaesarCipher();
        fileService = new FileService();
    }

    public void processCommand(String[] args) {
        String command = args[0];
        String filePath = args[1];
        int key = Integer.parseInt(args[2]);

        try {
            String text = fileService.readFile(filePath);
            String result;

            if (command.equals(ENCRYPT_COMMAND)) {
                result = caesarCipher.encrypt(text, key);
                filePath = addTagToFilePath(filePath, "[ENCRYPTED]");
            } else if (command.equals(DECRYPT_COMMAND)) {
                result = caesarCipher.decrypt(text, key);
                filePath = addTagToFilePath(filePath, "[DECRYPTED]");
            } else if (command.equals(BRUTE_FORCE_COMMAND)) {
                result = caesarCipher.bruteForce(text);
                filePath = addTagToFilePath(filePath, "[BRUTE_FORCE]");
            } else {
                System.out.println("Invalid command.");
                return;
            }

            fileService.writeFile(filePath, result);
            System.out.println("Operation completed successfully. Result saved to: " + filePath);
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    private String addTagToFilePath(String filePath, String tag) {
        int dotIndex = filePath.lastIndexOf(".");
        return filePath.substring(0, dotIndex) + tag + filePath.substring(dotIndex);
    }
}
