package demo.spring.rest.controllers.api;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.web.util.UriComponentsBuilder;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ApplicationControllerTests {
    private final static String HOST = "http://localhost:";
    private final static String URI = "/last-application-contact/";
    private final static int CONTACT_ID_1 = 1;
    private final static int CONTACT_ID_100 = 100;
    private final static String CONTACT_ID_ERROR_VALUE = "abc";
    private final static String QUERY_PARAMETR_TYPE = "mediaType";
    private final static String FORMAT_XML = "xml";
    private final static String RESPONSE_CONTACT_JSON = "{\"APPLICATION_ID\":1,\"CONTACT_ID\":1," +
        "\"DT_CREATED\":\"2020-10-04@09:01:01.690+0300\",\"PRODUCT_NAME\":\"Debit card\"}";
    private final static String RESPONSE_CONTACT_XML = "<?xml version=\"1.0\" encoding=\"UTF-8\" " +
        "standalone=\"yes\"?><APPLICATION><APPLICATION_ID>1</APPLICATION_ID><CONTACT_ID>1</CONTACT_ID>" +
        "<DT_CREATED>2020-10-04T09:01:01.690+03:00</DT_CREATED><PRODUCT_NAME>Debit card</PRODUCT_NAME></APPLICATION>";
    private final static String RESPONSE_CONTACT_NO_FOUND = "{\"error\" : " +
        "\"Could not find application for contact with id 100\"}";
    private final static String RESPONSE_CONTACT_ERROR_VALUE = "{\"error\" : \"Incorrect value Id\"}";

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    void getLastApplicationJson() {
        UriComponentsBuilder builder = UriComponentsBuilder
            .fromHttpUrl(HOST + port + URI + CONTACT_ID_1);
        ResponseEntity<String> response = sendRequest(builder);

        assertEquals(RESPONSE_CONTACT_JSON, response.getBody());
    }

    @Test
    void getLastApplicationXml() {
        UriComponentsBuilder builder = UriComponentsBuilder
            .fromHttpUrl(HOST + port + URI + CONTACT_ID_1)
            .queryParam(QUERY_PARAMETR_TYPE, FORMAT_XML);
        ResponseEntity<String> response = sendRequest(builder);

        assertEquals(RESPONSE_CONTACT_XML, response.getBody());
    }

    @Test
    void getLastApplicationNoFound() {
        UriComponentsBuilder builder = UriComponentsBuilder
            .fromHttpUrl(HOST + port + URI + CONTACT_ID_100);
        ResponseEntity<String> response = sendRequest(builder);

        assertEquals(RESPONSE_CONTACT_NO_FOUND, response.getBody());
    }

    @Test
    void getLastApplicationBadRequest() {
        UriComponentsBuilder builder = UriComponentsBuilder
            .fromHttpUrl(HOST + port + URI + CONTACT_ID_ERROR_VALUE);
        ResponseEntity<String> response = sendRequest(builder);

        assertEquals(RESPONSE_CONTACT_ERROR_VALUE, response.getBody());
    }

    @Test
    void getAllContact() {
        UriComponentsBuilder builder = UriComponentsBuilder
            .fromHttpUrl(HOST + port + URI + CONTACT_ID_ERROR_VALUE);
        ResponseEntity<String> response = sendRequest(builder);

        assertEquals(RESPONSE_CONTACT_ERROR_VALUE, response.getBody());
    }

    private ResponseEntity<String> sendRequest(UriComponentsBuilder builder) {
        HttpEntity<?> entity = new HttpEntity<>(new HttpHeaders());

        return testRestTemplate.exchange(
            builder.toUriString(),
            HttpMethod.GET,
            entity,
            String.class);
    }
}
