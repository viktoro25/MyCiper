package CaesarCipher;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * The CaesarCipher class represents a simple implementation of the Caesar cipher algorithm.
 * It can encrypt and decrypt text messages using a specified key.
 */
public class CaesarCipher {
    private final ArrayList<Character> alphabet;
    private final String specialCharacters;

    /**
     * Constructs a CaesarCipher object with the default English alphabet and special characters.
     */
    public CaesarCipher() {
        alphabet = new ArrayList<>(
                Arrays.asList(
                        'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L',
                        'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X',
                        'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
                        'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v',
                        'w', 'x', 'y', 'z', '.', ',', '«', '»', '"', '\'', ':', '!',
                        '?', ' '
                )
        );
        specialCharacters = ".,«»\":!?  ";
    }

    /**
     * Encrypts the given text using the specified key.
     *
     * @param text The text to be encrypted.
     * @param key  The encryption key.
     * @return The encrypted text.
     */
    public String encrypt(String text, int key) {
        StringBuilder result = new StringBuilder();

        for (char character : text.toCharArray()) {
            if (isEncryptableCharacter(character)) {
                int index = alphabet.indexOf(character);
                int encryptedIndex = (index + key) % alphabet.size();
                char encryptedChar = alphabet.get(encryptedIndex);
                result.append(encryptedChar);
            } else {
                result.append(character);
            }
        }

        return result.toString();
    }

    /**
     * Decrypts the given text using the specified key.
     *
     * @param text The text to be decrypted.
     * @param key  The decryption key.
     * @return The decrypted text.
     */
    public String decrypt(String text, int key) {
        StringBuilder result = new StringBuilder();

        for (char character : text.toCharArray()) {
            if (isEncryptableCharacter(character)) {
                int index = alphabet.indexOf(character);
                int decryptedIndex = (index - key + alphabet.size()) % alphabet.size();
                char decryptedChar = alphabet.get(decryptedIndex);
                result.append(decryptedChar);
            } else {
                result.append(character);
            }
        }

        return result.toString();
    }

    /**
     * Performs a brute force decryption on the given text, trying all possible keys.
     *
     * @param text The text to be decrypted.
     * @return The decrypted text for each possible key.
     */
    public String bruteForce(String text) {
        StringBuilder result = new StringBuilder();

        for (int key = 1; key < alphabet.size(); key++) {
            result.append("Key ").append(key).append(": ").append(decrypt(text, key)).append("\n");
        }

        return result.toString();
    }

    /**
     * Checks if the given character is encryptable.
     *
     * @param character The character to be checked.
     * @return {@code true} if the character is encryptable, {@code false} otherwise.
     */
    private boolean isEncryptableCharacter(char character) {
        return alphabet.contains(character) || specialCharacters.indexOf(character) != -1;
    }
}