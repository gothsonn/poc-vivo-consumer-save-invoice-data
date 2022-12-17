package com.accenture.pocvivoconsumersaveinvoicedata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class PocVivoConsumerSaveInvoiceDataApplication {

    public static void main(String[] args) {
        SpringApplication.run(PocVivoConsumerSaveInvoiceDataApplication.class, args);
    }

}
