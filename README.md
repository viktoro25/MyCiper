# Caesar Cipher Program

The Caesar Cipher Program is a command-line application that allows you to encrypt, decrypt, and brute force encrypted text using the Caesar cipher algorithm.

## Features

- Encrypt: Encrypts a text file using the Caesar cipher algorithm.
- Decrypt: Decrypts a previously encrypted text file using the Caesar cipher algorithm.
- Brute Force: Attempts to decrypt an encrypted text file by trying all possible key combinations.

## Getting Started

### Prerequisites

- Java Development Kit (JDK) installed on your system.

### Installation

1. Clone the repository or download the source code.
2. Open a terminal and navigate to the project directory.
3. Compile the source code using the following command:
javac -d bin src/*.java

## Usage

To run the program, use the following command:

java -cp bin Runner

The program will prompt you for a command and file path. You can choose from the following commands:

- E or e: Encrypt
- D or d: Decrypt
- B or b: Brute Force

After entering the command and file path, the program may prompt for additional information, such as the encryption key.

Once the command is executed successfully, the program will display a message indicating the result and the location of the output file.

## Examples

Here are some examples of how to use the program:

- Encrypt a file:
Enter command (E - ENCRYPT, D - DECRYPT, B - BRUTE_FORCE): E
Enter file path: input.txt
Enter key: 3

- Decrypt a file:
Enter command (E - ENCRYPT, D - DECRYPT, B - BRUTE_FORCE): D
Enter file path: encrypted.txt
Enter key: 3

- Brute force decryption:
Enter command (E - ENCRYPT, D - DECRYPT, B - BRUTE_FORCE): B
Enter file path: encrypted.txt

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

## Acknowledgments

- The Caesar cipher algorithm implementation is based on the work of [Caesar Cipher](https://en.wikipedia.org/wiki/Caesar_cipher).
- Special thanks to the contributors of the Caesar Cipher Program.

Feel free to modify this README file to suit your project's specific needs.
