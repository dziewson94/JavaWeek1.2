package com.sii.acadamy.token;

import com.sii.acadamy.util.FileUtils;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Logger;

import static javax.xml.parsers.SAXParserFactory.newInstance;

public class TokenConfigurationParser {
    private static final String CONFIG_PATH = "configuration/config.xml";
    private static final Logger logger = Logger.getLogger(TokenConfigurationParser.class.getName());

    private TokenConfigurationParser() {
    }

    public static TokenConfiguration parseTokenConfiguration() throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory saxParserFactory = newInstance();
        saxParserFactory.setFeature("http://xml.org/sax/features/external-general-entities", false);
        SAXParser saxParser = saxParserFactory.newSAXParser();
        logger.info("Reading configuration : from " + CONFIG_PATH);
        InputStream is = FileUtils.getFileFromResourceAsStream(CONFIG_PATH);
        TokenConfigurationHandler tokenConfigurationHandler = new TokenConfigurationHandler();
        saxParser.parse(is, tokenConfigurationHandler);
        return tokenConfigurationHandler.getConfiguration();

    }


}
