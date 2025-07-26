package Basic_Projects;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class PasswordGenerator {
    private static final int MIN_PASSWORD_LENGTH = 8;
    private static final String LETTERS     = "abcdefghijklmnopqrstuvwxyz";
    private static final String DIGITS      = "0123456789";
    private static final String SPECIALS    = "!@#$%^&*()-*/";

    public static void main(String[] args) {
        generatePassword();
    }

    private static void generatePassword() {
        Scanner sc = new Scanner(System.in);

        int length       = promptForLength(sc);
        int specialCount = promptForCount(sc, "special characters", length);
        int digitCount   = promptForCount(sc, "digits", length - specialCount);

        String password  = buildPassword(length, specialCount, digitCount);
        System.out.println("Generated password: " + password);

        sc.close();
    }

    private static int promptForLength(Scanner sc) {
        while (true) {
            System.out.print("Enter the length of the password (minimum " 
                             + MIN_PASSWORD_LENGTH + "): ");
            String line = sc.nextLine().trim();
            try {
                int len = Integer.parseInt(line);
                if (len >= MIN_PASSWORD_LENGTH) {
                    return len;
                }
                System.out.println("Password length must be at least " 
                                   + MIN_PASSWORD_LENGTH + ".");
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }

    private static int promptForCount(Scanner sc, String type, int maxAllowed) {
        System.out.print("Do you want to include " + type + "? (yes/no): ");
        String yn = sc.nextLine().trim().toLowerCase();
        if (!yn.equals("yes")) {
            return 0;
        }

        while (true) {
            System.out.print("How many " + type + " (0 to " + maxAllowed + "): ");
            String line = sc.nextLine().trim();
            try {
                int count = Integer.parseInt(line);
                if (count >= 0 && count <= maxAllowed) {
                    return count;
                }
                System.out.println("Enter a number between 0 and " + maxAllowed + ".");
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Enter a number.");
            }
        }
    }

    private static String buildPassword(int length, int specialCount, int digitCount) {
        Random random = new Random();
        List<Character> chars = new ArrayList<>();

        // 1) Guarantee first character is a letter
        chars.add(LETTERS.charAt(random.nextInt(LETTERS.length())));

        // 2) Fill with remaining letters
        int lettersToAdd = length - specialCount - digitCount - 1;
        for (int i = 0; i < lettersToAdd; i++) {
            chars.add(LETTERS.charAt(random.nextInt(LETTERS.length())));
        }

        // 3) Add digits
        for (int i = 0; i < digitCount; i++) {
            chars.add(DIGITS.charAt(random.nextInt(DIGITS.length())));
        }

        // 4) Add special characters
        for (int i = 0; i < specialCount; i++) {
            chars.add(SPECIALS.charAt(random.nextInt(SPECIALS.length())));
        }

        // 5) Shuffle everything except the first character
        Collections.shuffle(chars.subList(1, chars.size()));

        StringBuilder sb = new StringBuilder();
        for (char c : chars) {
            sb.append(c);
        }
        return sb.toString();
    }
}