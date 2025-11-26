package org.example.supplierservice;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class SupplierControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void contextLoadsAndGetSuppliers() {
        ResponseEntity<String> response = restTemplate.getForEntity("/api/suppliers", String.class);
        assert(response.getStatusCode().is2xxSuccessful());
    }
}
