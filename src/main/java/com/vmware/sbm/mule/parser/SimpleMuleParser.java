package com.vmware.sbm.mule.parser;

import org.w3c.dom.*;
import org.xml.sax.SAXParseException;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.InputStream;

// Simple 1 2 3
public class SimpleMuleParser {

    public Document parseMuleConfigurationAsDom(InputStream resourceAsStream) {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

        try {
            dbf.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
            DocumentBuilder db = dbf.newDocumentBuilder();
            return db.parse(resourceAsStream);
        }
        catch (SAXParseException e) {
            throw new RuntimeException("Error Parsing XML : " + e.getMessage(), e);
        }
        catch (Exception e) {
            // swallow - TODO:
            return null;
        }
    }
}
