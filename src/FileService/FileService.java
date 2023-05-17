package FileService;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileService {
    /**
     * Reads the content of a file.
     *
     * @param filePath The path to the file.
     * @return The content of the file as a string.
     * @throws IOException If an I/O error occurs while reading the file.
     */
    public String readFile(String filePath) throws IOException {
        StringBuilder content = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        }

        return content.toString();
    }

    /**
     * Writes content to a file.
     *
     * @param filePath The path to the file.
     * @param content  The content to be written.
     * @throws IOException If an I/O error occurs while writing the file.
     */
    public void writeFile(String filePath, String content) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(content);
        }
    }
}
