package com.sii.acadamy.token;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Logger;

public class TokenGenerator {
    private static final Logger logger = Logger.getLogger(TokenGenerator.class.getName());
    private TokenGenerator() {}
    public static Token buildToken() throws ParserConfigurationException, IOException, SAXException {
        TokenConfiguration tokenConfiguration = TokenConfigurationParser.parseTokenConfiguration();
        logger.info("Please provide desired token length, Choose between %s".formatted(tokenConfiguration));
        return new Token(buildToken(readUserInput(tokenConfiguration.getAllowedValues())));
    }

    private static int readUserInput(List<Integer> allowedValues) {
        int attemption = 0;
        while (true) {
            if (attemption == 3)
                throw new RuntimeException("Too many attempts");
            Scanner scanner = new Scanner(System.in);
            try {
                int userInput = scanner.nextInt();
                if (doesListContainValue(userInput, allowedValues)) {
                    return userInput;
                }
            } catch (Exception ignored) {
            }
            logger.warning("Please read instructions carefully, pay attention to token length");
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
        return tokenBuilder.toString();

    }

    private static boolean doesListContainValue(int value, List<Integer> list) {
        for (Integer s : list) {
            if (s == value) {
                return true;
            }
        }
        return false;
    }


}
