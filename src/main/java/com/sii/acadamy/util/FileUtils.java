package com.sii.acadamy.util;

import com.sii.acadamy.token.TokenConfigurationParser;

import java.io.InputStream;

public class FileUtils {
    private FileUtils() {
    }

    public static InputStream getFileFromResourceAsStream(String file) {

        ClassLoader classLoader = TokenConfigurationParser.class.getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(file);
        if (inputStream == null) {
            throw new IllegalArgumentException("Config file not found! " + file);
        } else {
            return inputStream;
        }

    }
}
