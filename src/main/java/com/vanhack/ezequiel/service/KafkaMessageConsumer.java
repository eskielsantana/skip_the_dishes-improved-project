package com.vanhack.ezequiel.service;

public interface KafkaMessageConsumer {
    String KAFKA_ADD = "ADD";
    String KAFKA_UPDATE = "UPDATE";
    String KAFKA_DELETE = "DELETE";

    void readMessage(String message);
}
