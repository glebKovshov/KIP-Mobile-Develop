import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

class CaesarCipher{
    private static final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";

    private static char shiftChar(char ch, int shift, String alphabet) {
        int index = alphabet.indexOf(ch);
        if (index == -1) return ch;
        int newIndex = (index + shift + alphabet.length()) % alphabet.length();
        return alphabet.charAt(newIndex);
    }

    public static String encrypt(String text, int shift) {
        StringBuilder result = new StringBuilder();
        for (char ch : text.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                result.append(shiftChar(ch, shift, UPPERCASE));
            } else if (Character.isLowerCase(ch)) {
                result.append(shiftChar(ch, shift, LOWERCASE));
            } else {
                result.append(ch);
            }
        }
        return result.toString();
    }

    public static String decrypt(String text, int shift) {
        return encrypt(text, -shift);
    }

    public static void processFile(String inputFile, String outputFile, int shift, boolean decrypt) throws IOException {
        String content = Files.lines(Paths.get(inputFile)).collect(Collectors.joining("\n"));
        String processedText = decrypt ? decrypt(content, shift) : encrypt(content, shift);
        Files.write(Paths.get(outputFile), processedText.getBytes());
    }

    public static void main(String[] args){
        if (args.length < 4) {
            System.out.println("Usage: java CaesarCipher.java <mode> <inputFile> <outputFile> <shift>");
            System.out.println("Mode: encrypt | decrypt");
            return;
        }

        String mode = args[0];
        String inputFile = args[1];
        String outputFile = args[2];
        int shift = Integer.parseInt(args[3]) % 26;

        try {
            processFile(inputFile, outputFile, shift, mode.equalsIgnoreCase("decrypt"));
            System.out.println("Processing complete. Output saved to: " + outputFile);
        } catch (IOException e) {
            System.err.println("Error processing file: " + e.getMessage());
        }
    }
}