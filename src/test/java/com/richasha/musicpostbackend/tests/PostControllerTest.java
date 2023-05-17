package com.richasha.musicpostbackend.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PostControllerTest {
    static private final String BASE_URL = "http://localhost:8089";

    @Autowired private TestRestTemplate template;

    @Test
    public void givenAuthRequest_shouldSucceedWith200() throws Exception {
        var result = template.withBasicAuth("timmy", "timmy")
                .getForEntity("/api/test", String.class);
        System.out.println(result.toString());
        Assertions.assertEquals(HttpStatus.OK, result.getStatusCode());
    }
}
