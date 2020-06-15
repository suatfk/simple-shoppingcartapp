package com.sc.app;

import com.sc.app.config.DataConfiguration;
import com.sc.app.config.MainConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({MainConfiguration.class, DataConfiguration.class})
public class ShoppingCartApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShoppingCartApplication.class, args);
    }
}
