package com.sii.acadamy.token;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

public class TokenConfigurationHandler extends DefaultHandler {
    private final StringBuilder currentValue = new StringBuilder();
    private final TokenConfiguration configuration = new TokenConfiguration();

    @Override
    public void startElement(
            String uri,
            String localName,
            String qName,
            Attributes attributes) {

        currentValue.setLength(0);


        if ("TokenConfiguration".equalsIgnoreCase(qName)) {
            String values = attributes.getValue("allowedLength");
            configuration.setAllowedValues(values);
        }


    }

    public TokenConfiguration getConfiguration() {
        return configuration;
    }

    @Override
    public void characters(char[] ch, int start, int length) {

        currentValue.append(ch, start, length);

    }

    @Override
    public String toString() {
        return "TokenConfigurationHandler{" +
                "currentValue=" + currentValue +
                ", configuration=" + configuration +
                '}';
    }
}
