package demo.spring.rest.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ContactTest {

    @Test
    void test() {
        final int ID = 1;
        final String NAME = "testName";
        Contact contactExpected = new Contact(ID, NAME);
        Contact contact = new Contact();
        contact.setId(ID);
        contact.setName(NAME);

        assertEquals(contactExpected, contact);
        assertEquals(ID, contact.getId());
        assertEquals(NAME, contact.getName());
    }
}
