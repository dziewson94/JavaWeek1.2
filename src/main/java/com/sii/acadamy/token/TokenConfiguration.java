package com.sii.acadamy.token;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class TokenConfiguration {
    private static final Logger logger = Logger.getLogger(TokenConfiguration.class.getName());

    private final List<Integer> allowedValues = new ArrayList<>();

    public List<Integer> getAllowedValues() {
        return allowedValues;
    }

    public void setAllowedValues(String valuesAsString) {
        String[] values = valuesAsString.split(",");
        for (String value : values) {
            try {
                allowedValues.add(Integer.parseInt(value));
            } catch (Exception e) {
               logger.warning("Check configuration xml " + e);
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        allowedValues.forEach(s -> stringBuilder.append(String.format("%d,", s)));
        return stringBuilder.substring(0, stringBuilder.length() - 1);
    }
}
