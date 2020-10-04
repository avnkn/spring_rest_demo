package demo.spring.rest;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.fail;

@SpringBootTest
class RestApplicationTest {

    @Test
    void contextLoads() {
        try {
            RestApplication.main(new String[]{""});
        } catch (Exception e) {
            fail();
        }
    }

}
