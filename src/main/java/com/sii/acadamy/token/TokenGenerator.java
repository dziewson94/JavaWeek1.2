package com.sii.acadamy.token;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class TokenGenerator {
    public static Token buildToken() {
        System.out.println("Please provide desired token length, Choose between 5,10 and 15");
        return new Token(buildToken(readUserInput()));
    }

    private static int readUserInput() {
        int attemption = 0;
        while (true) {
            if (attemption == 3)
                throw new RuntimeException("Too many attempts");
            Scanner scanner = new Scanner(System.in);
            try {
                int userInput = scanner.nextInt();
                if (userInput == 5 || userInput == 10 || userInput == 15) {
                    return userInput;
                }
            } catch (Exception ignored) {

            }
            System.out.println("Please read instructions carefully, pay attention to token length");
            attemption++;
        }
    }

    private static String buildToken(int length) {

        int lowerASCIBoundary = 33;
        int upperASCIBoundary = 127;
        StringBuilder tokenBuilder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            char charToAppend = (char) ThreadLocalRandom.current().nextInt(lowerASCIBoundary, upperASCIBoundary);
            tokenBuilder.append(charToAppend);
        }
        System.out.println(tokenBuilder.length());
        return tokenBuilder.toString();

    }


}
