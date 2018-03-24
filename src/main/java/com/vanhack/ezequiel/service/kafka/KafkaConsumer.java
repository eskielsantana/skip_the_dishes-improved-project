package com.vanhack.ezequiel.service.kafka;

import com.google.gson.Gson;
import com.vanhack.ezequiel.dto.restDto.OrderRestDto;
import com.vanhack.ezequiel.service.OrderBusinessLogicService;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer{
//    private static final Logger LOGGER = LogManager.getLogger("KafkaConsumer");

    @Autowired
    private OrderBusinessLogicService orderBusinessLogicService;

    private final static String topic = "TopicName1";

    @KafkaListener(topics = topic)
    public void receive(ConsumerRecord<?, ?> consumerRecord) {
//        LOGGER.info("A new Country Message was posted on Kafka country's topic");
        try {
            OrderRestDto orderRestDto = new Gson().fromJson((String)consumerRecord.value(), OrderRestDto.class);
//            LOGGER.info("Country message was successfully deserialized");
            System.out.println(consumerRecord.value());
            orderBusinessLogicService.requestOrder(orderRestDto);

        } catch (Exception e) {
            e.printStackTrace();
//            LOGGER.error("Failed to read country message.");
        }
    }
}