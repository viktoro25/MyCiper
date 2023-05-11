package CaesarCipher;

import java.util.ArrayList;
import java.util.Arrays;

public class CaesarCipher {
    public static final ArrayList<Character> ALPHABET = new ArrayList<>(
            Arrays.asList(
                    'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L',
                    'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X',
                    'Y', 'Z','.',',','«','»','"','\'',':','!','?',' '
            )
    );
    private static final String SPECIAL_CHARACTERS = ".,«»\":!?  ";

    public static String encrypt(String text, int key) {
        StringBuilder result = new StringBuilder();

        for (char character : text.toCharArray()) {
            if (isEncryptableCharacter(character)) {
                int index = ALPHABET.indexOf(Character.toUpperCase(character));
                int encryptedIndex = (index + key) % ALPHABET.size();
                char encryptedChar = ALPHABET.get(encryptedIndex);
                result.append(encryptedChar);
            } else {
                result.append(character);
            }
        }

        return result.toString();
    }

    public static String decrypt(String text, int key) {
        StringBuilder result = new StringBuilder();

        for (char character : text.toCharArray()) {
            if (isEncryptableCharacter(character)) {
                int index = ALPHABET.indexOf(Character.toUpperCase(character));
                int decryptedIndex = (index - key + ALPHABET.size()) % ALPHABET.size();
                char decryptedChar = ALPHABET.get(decryptedIndex);
                result.append(decryptedChar);
            } else {
                result.append(character);
            }
        }

        return result.toString();
    }

    public static String bruteForce(String text) {
        StringBuilder result = new StringBuilder();

        for (int key = 1; key < ALPHABET.size(); key++) {
            result.append("Key ").append(key).append(": ").append(decrypt(text, key)).append("\n");
        }

        return result.toString();
    }

    private static boolean isEncryptableCharacter(char character) {
        return ALPHABET.indexOf(Character.toUpperCase(character)) != -1 || SPECIAL_CHARACTERS.indexOf(character) != -1;
    }
}
