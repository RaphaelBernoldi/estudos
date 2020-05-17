package br.com.estudos;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.util.Map;
import java.util.regex.Pattern;

public class LogService<T> {

    public static void main(String[] args) {
        LogService logService = new LogService();
        try(KafkaConsumerService kafkaConsumer = new KafkaConsumerService(LogService.class.getName()
                                                                        , Pattern.compile("ECOMMERCE_.*")
                                                                        , logService::parse
                                                                        , String.class
                                                                        , Map.of(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class))) {
            kafkaConsumer.run();
        }
    }

    private void parse(ConsumerRecord<String, T> record){
        System.out.println("::::::::::::::::::::::::::::::::::::READ-MESSAGE::::::::::::::::::::::::::::::::::::");
        System.out.println(record.key());
        System.out.println(record.topic());
        System.out.println(record.value());
        System.out.println("::::::::::::::::::::::::::::::::::::END-MESSAGE::::::::::::::::::::::::::::::::::::");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
