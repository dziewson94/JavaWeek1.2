package com.sii.acadamy.main;

import com.sii.acadamy.token.TokenGenerator;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.logging.Logger;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        logger.info((TokenGenerator.buildToken().toString()));
    }
}
