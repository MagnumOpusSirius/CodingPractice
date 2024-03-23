package com.demo.HackerRank;

public class OnbeProblem2 {
    public static void main(String[] args) {
        String encryptedMessage = "cdeb nqxg ccc";
        String knownWord = "love";

        String decryptedMessage = decipher(encryptedMessage, knownWord);
        System.out.println("Decrypted Message: " + decryptedMessage);
    }

    public static String decipher(String encryptedMessage, String knownWord) {
        // Find the number of shifts to decrypt the known word
        int shift = calculateShift(encryptedMessage, knownWord);

        // Decrypt the entire message using the calculated shift
        StringBuilder decryptedMessage = new StringBuilder();
        for (char c : encryptedMessage.toCharArray()) {
            if (Character.isLetter(c)) {
                char decryptedChar = (char) (c - shift);
                if ((Character.isLowerCase(c) && decryptedChar < 'a') || (Character.isUpperCase(c) && decryptedChar < 'A')) {
                    decryptedChar += 26;
                }
                decryptedMessage.append(decryptedChar);
            } else {
                decryptedMessage.append(c);
            }
        }

        return decryptedMessage.toString();
    }

    public static int calculateShift(String encryptedMessage, String knownWord) {
        int shift = 0;

        for (int i = 0; i <= encryptedMessage.length() - knownWord.length(); i++) {
            String substring = encryptedMessage.substring(i, i + knownWord.length());
            int currentShift = 0;
            for (int j = 0; j < knownWord.length(); j++) {
                int encryptedAscii = Character.toLowerCase(substring.charAt(j)) - 'a';
                int knownAscii = Character.toLowerCase(knownWord.charAt(j)) - 'a';
                currentShift = (encryptedAscii - knownAscii + 26) % 26;
                if (currentShift != 2) {
                    break; // If shift is not 2, move to the next substring
                }
            }
            if (currentShift == 2) {
                shift = currentShift;
                break; // If shift is 2, we found the correct shift, no need to check further
            }
        }

        return shift;
    }
}
