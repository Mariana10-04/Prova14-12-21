package com.prova_1412.prova_1412.testIntegracao;

import com.prova_1412.prova_1412.model.Forncedor;
import com.prova_1412.prova_1412.repository.FornecedorRepository;
import com.prova_1412.prova_1412.util.FornecedorCreat;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;

import java.util.UUID;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY)
public class FornecedorTestIntegracao {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Autowired
    private FornecedorRepository repository;

    @LocalServerPort
    private int port;

    @BeforeEach
    void setUp() {
        repository.deleteAll();
        repository.save(FornecedorCreat.createFornecedor());
    }

    @Test
    public void testeClaudinho() {

        Forncedor fornecedor = new Forncedor(UUID.randomUUID(), "Fornecedor teste");

        ResponseEntity<Forncedor[]> exchange =
                testRestTemplate.exchange("/api/fornecedores", HttpMethod.GET, null, Forncedor[].class);

        Assertions.assertThat(exchange).isNotNull();
        Assertions.assertThat(exchange.getStatusCode()).isEqualTo(HttpStatus.OK);
        Assertions.assertThat(exchange.getBody().length).isEqualTo(1);
    }
}