package com.dummyjson_client;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DummyjsonClientApplicationTests {

	@Test
    void contextLoads() {
        // Esse teste verifica se o contexto da aplicação é carregado sem problemas
        DummyjsonClientApplication.main(new String[]{});
    }

}
