package br.com.estudos;

import org.apache.kafka.clients.consumer.ConsumerRecord;

import java.util.Map;

public class FraudDetectorService {

    public static void main(String[] args) {
        FraudDetectorService fraudDetectorService = new FraudDetectorService();
        try(KafkaConsumerService kafkaConsumer = new KafkaConsumerService(FraudDetectorService.class.getName(), "ECOMMERCE_NEW_ORDER", fraudDetectorService::parse, Order.class, Map.of())) {
            kafkaConsumer.run();
        }
    }

    private void parse(ConsumerRecord<String, Order> record){
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
