package com.vmware.sbm.mule.parser;

import org.junit.jupiter.api.Test;
import org.w3c.dom.Document;

import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class SimpleMuleParserTest {
    private SimpleMuleParser parser = new SimpleMuleParser();

    @Test
    public void shouldReadXmlDocument() {
        InputStream resourceAsStream = this.getClass().getResourceAsStream("/mule-configs-amqp/amqp-listen-publish.xml");

        Document document = parser.parseMuleConfigurationAsDom(resourceAsStream);

        assertNotNull(document);
        assertEquals(document.getDocumentElement().getNodeName(), "mule");
    }
}
