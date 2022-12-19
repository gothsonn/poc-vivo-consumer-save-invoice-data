package com.accenture.pocvivoconsumersaveinvoicedata.adapters.listener;

import com.accenture.pocvivoconsumersaveinvoicedata.infrastructure.adapters.entity.FinancialAccountDao;
import com.accenture.pocvivoconsumersaveinvoicedata.dominio.dtos.FinancialAccountCreateEvent;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
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
    Gson gson = new Gson();
    @KafkaListener(topics = "${topic.name.consumer}", groupId = "${spring.kafka.consumer.group-id}")
    public void consume(ConsumerRecord<String, String> payload){
        log.info("Tópico: {}", topicName);
        log.info("key: {}", payload.key());
        log.info("Headers: {}", payload.headers());
        log.info("Partion: {}", payload.partition());
        log.info("Payload: {}", payload.value());
        try {
            FinancialAccountCreateEvent consumeToFinancial =  objectMapper.readValue(payload.value(), FinancialAccountCreateEvent.class);
//            System.out.println(gson.toJson(payload.value()));
//            FinancialAccountCreate consumeToSaveInvoice =  objectMapper.readValue(consumeToFinancial.getPayload().getFinancialAccount(), FinancialAccountCreate.class);
            System.out.println(consumeToFinancial);
            dao.createFinancialAccount(consumeToFinancial.getPayload().getFinancialAccount());
            log.info("FinancialAccountCreateEvent: {}", consumeToFinancial.getPayload().getFinancialAccount());

        } catch (IOException e) {
            log.error("Couldn't serialize response for content type application/json", e);

        }
    }

}