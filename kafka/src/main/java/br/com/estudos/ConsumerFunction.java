package br.com.estudos;

import org.apache.kafka.clients.consumer.ConsumerRecord;

public interface ConsumerFunction {
    void parse(ConsumerRecord<String, String> record);
}
