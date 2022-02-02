package com.vmware.sbm.mule.parser;

import org.w3c.dom.*;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.InputStream;

public class SimpleMuleParser {

    public Document parseMuleConfigurationAsDom(InputStream resourceAsStream) {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

        try {
            dbf.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
            DocumentBuilder db = dbf.newDocumentBuilder();
            return db.parse(resourceAsStream);
        }
        catch (Exception e) {
            // swallow -- TODO:
        }

        return null;
    }
}
