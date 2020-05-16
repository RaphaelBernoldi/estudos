package br.com.estudos;

import org.apache.kafka.clients.consumer.ConsumerRecord;

public class LogService {

    public static void main(String[] args) {
        LogService logService = new LogService();
        try(KafkaConsumerService kafkaConsumer = new KafkaConsumerService(LogService.class.getName(), "ECOMMERCE_NEW_ORDER", logService::parse)) {
            kafkaConsumer.run();
        }
    }

    private void parse(ConsumerRecord<String, String> record){
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
