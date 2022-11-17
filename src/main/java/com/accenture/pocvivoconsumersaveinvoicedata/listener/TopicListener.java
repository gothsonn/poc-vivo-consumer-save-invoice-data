package com.accenture.pocvivoconsumersaveinvoicedata.listener;

import com.accenture.pocvivoconsumersaveinvoicedata.dao.FinancialAccountDao;
import com.accenture.pocvivoconsumersaveinvoicedata.model.FinancialAccountCreate;
import com.accenture.pocvivoconsumersaveinvoicedata.model.FinancialAccountCreateEvent;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;


@Slf4j
@RequiredArgsConstructor
@Service
public class TopicListener {

    @Autowired
    private FinancialAccountDao dao;
    @Value("${topic.name.consumer")
    private String topicName;
    private final ObjectMapper objectMapper;

    @KafkaListener(topics = "${topic.name.consumer}", groupId = "${spring.kafka.consumer.group-id}")
    public void consume(ConsumerRecord<String, String> payload){
        log.info("Tópico: {}", topicName);
        log.info("key: {}", payload.key());
        log.info("Headers: {}", payload.headers());
        log.info("Partion: {}", payload.partition());
        try {
            FinancialAccountCreate consumeToSaveInvoice =  objectMapper.readValue(payload.value(), FinancialAccountCreate.class);
            System.out.println(consumeToSaveInvoice);
            dao.createFinancialAccount(consumeToSaveInvoice);
            log.info("FinancialAccountCreateEvent: {}", consumeToSaveInvoice);

        } catch (IOException e) {
            log.error("Couldn't serialize response for content type application/json", e);

        }
    }

}