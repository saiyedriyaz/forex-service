package com.github.saiyedriyaz.service.forex.currency.integration;

import com.github.saiyedriyaz.service.forex.currency.controller.CurrencyController;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class CurencyApplicationTests {

    @Test
    void contextLoads(ApplicationContext context) {
        assertNotNull(context);
        assertNotNull(context.getBean(CurrencyController.class));
    }

}
