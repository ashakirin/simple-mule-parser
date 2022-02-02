package com.vmware.sbm.mule.parser;

import org.junit.jupiter.api.Test;
import org.w3c.dom.Document;

import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class SimpleMuleParserTest {
    private final SimpleMuleParser parser = new SimpleMuleParser();

    @Test
    public void shouldReadXmlDocument() {
        InputStream resourceAsStream = this.getClass().getResourceAsStream("/mule-configs-amqp/amqp-listen-publish.xml");

        Document document = parser.parseMuleConfigurationAsDom(resourceAsStream);

        assertNotNull(document);
        assertEquals(document.getDocumentElement().getNodeName(), "mule");
    }

    @Test
    public void shouldReportAnErrorWhenInvalidXMLIsProvided() {
        InputStream resourceAsStream = this.getClass().getResourceAsStream("/mule-configs-amqp/invalid.xml");

        RuntimeException thrown = assertThrows(RuntimeException.class, () -> {
            parser.parseMuleConfigurationAsDom(resourceAsStream);
        });

        assertEquals(thrown.getMessage(), "Error Parsing XML : Content is not allowed in prolog.");
    }
}
